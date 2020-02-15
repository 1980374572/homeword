package com.bnn.controller;

import com.bnn.entity.*;
import com.bnn.entity.Class;
import com.bnn.request.Search;
import com.bnn.service.HomeworkService;
import com.bnn.utils.FileUtils;
import com.bnn.utils.SendMailUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    //列表
    @RequestMapping("/findAll")
    public PageInfo<Homework> findAllBySearch(Search search){
        PageHelper.startPage(search.getPageNum(),search.getPageSize());
        List<Homework> findAllBySearch = homeworkService.findAllBySearch(search);
        PageInfo<Homework> homeworkPageInfo = new PageInfo<>(findAllBySearch);
        return homeworkPageInfo;
    }

    //上传
    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        String newFileName = FileUtils.upload(file, "G:/img/v/", file.getOriginalFilename());
        return newFileName;
    }

    //添加
    @RequestMapping("/add")
    public int add(@RequestBody Homework homework){
        int insert = homeworkService.insert(homework);
        if(insert == 1){
            List<Student> students = homeworkService.findAllStu();
            for (Student s:students) {
                try {
                    SendMailUtil.sendSimpleMail(s.getEmail(),s.getName(),homework.getFinishDate());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                logger.info("发送成功！！");
                homework.setNotifyStatus("发送成功");
                homeworkService.insert(homework);
            }
        }else {
            homework.setNotifyStatus("发送失败");
            homeworkService.insert(homework);
            logger.info("发送失败！！");
        }
        return insert;
    }

    //下拉列表
    @RequestMapping("/findAllByCourse")
    public List<Course> findAllByCourse(){
        return homeworkService.findAllByCourse();
    }
    @RequestMapping("/findAllByClass")
    public List<Class> findAllByClass(){
        return homeworkService.findAllByClass();
    }
    @RequestMapping("/findAllByTeacher")
    public List<Teacher> findAllByTeacher(){
        return homeworkService.findAllByTeacher();
    }
}
