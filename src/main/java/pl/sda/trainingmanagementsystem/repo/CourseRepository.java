package pl.sda.trainingmanagementsystem.repo;

import org.springframework.data.repository.CrudRepository;
import pl.sda.trainingmanagementsystem.domain.Course;

public interface CourseRepository extends CrudRepository <Course, Integer> {
}
