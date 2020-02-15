package com.bnn.mapper;

import com.bnn.entity.*;
import com.bnn.entity.Class;
import com.bnn.request.Search;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);

    List<Homework> findAllBySearch(Search search);

    List<Course> findAllByCourse();

    List<Class> findAllByClass();

    List<Teacher> findAllByTeacher();

    List<Student> findAllStu();
}