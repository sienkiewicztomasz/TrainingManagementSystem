package pl.sda.trainingmanagementsystem.service;

import pl.sda.trainingmanagementsystem.domain.Course;
import pl.sda.trainingmanagementsystem.domain.Lecture;

import java.util.List;

public interface LectureService {

    List<Lecture> listAllLecture();

    Lecture getById(Integer id);

    Lecture save(Lecture lecture);

    void delete(Integer id);
}
