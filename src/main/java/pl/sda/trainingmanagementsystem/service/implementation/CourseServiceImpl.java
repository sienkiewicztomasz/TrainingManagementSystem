package pl.sda.trainingmanagementsystem.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.trainingmanagementsystem.domain.Course;
import pl.sda.trainingmanagementsystem.repo.CourseRepository;
import pl.sda.trainingmanagementsystem.service.CourseService;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl() {
    }

    @Override
    public List<Course> listAllCourse() {
        List<Course> result = new LinkedList<>();
        courseRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Course getById(Integer id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.orElse(new Course());
    }

    @Override
    public Course save(Course course) {
        if (course != null) {
            return courseRepository.save(course);
        }else {
            throw new RuntimeException("Nie mogę zapisać kursu!!! Wypełnij wszystkie pola!!!");
        }

    }


    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }


}
