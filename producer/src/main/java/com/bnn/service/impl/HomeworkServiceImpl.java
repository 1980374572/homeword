package com.bnn.service.impl;

import com.bnn.entity.*;
import com.bnn.entity.Class;
import com.bnn.mapper.HomeworkMapper;
import com.bnn.request.Search;
import com.bnn.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    HomeworkMapper homeworkMapper;

    @Override
    public List<Homework> findAllBySearch(Search search) {
        return homeworkMapper.findAllBySearch(search);
    }

    @Override
    public List<Course> findAllByCourse() {
        return homeworkMapper.findAllByCourse();
    }

    @Override
    public List<Class> findAllByClass() {
        return homeworkMapper.findAllByClass();
    }

    @Override
    public List<Teacher> findAllByTeacher() {
        return homeworkMapper.findAllByTeacher();
    }

    @Override
    public int insert(Homework homework) {
        if(homework.getId() == null){
            homeworkMapper.insert(homework);
        }else {
            homeworkMapper.updateByPrimaryKey(homework);
        }
        return 1;
    }

    @Override
    public List<Student> findAllStu() {
        return homeworkMapper.findAllStu();
    }
}
