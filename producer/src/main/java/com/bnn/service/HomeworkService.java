package com.bnn.service;

import com.bnn.entity.*;
import com.bnn.entity.Class;
import com.bnn.request.Search;

import java.util.List;

public interface HomeworkService {

    List<Homework> findAllBySearch(Search search);

    List<Course> findAllByCourse();

    List<Class> findAllByClass();

    List<Teacher> findAllByTeacher();

    int insert(Homework homework);

    List<Student> findAllStu();
}
