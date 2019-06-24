package pl.sda.trainingmanagementsystem.service;

import pl.sda.trainingmanagementsystem.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> listAllCourse();

    Course getById(Integer id);

    Course save(Course customer);

    void delete(Integer id);
}
