package pl.sda.trainingmanagementsystem.repo;

import org.springframework.data.repository.CrudRepository;
import pl.sda.trainingmanagementsystem.domain.Lecture;

public interface LectureRepository extends CrudRepository<Lecture, Integer> {

}
