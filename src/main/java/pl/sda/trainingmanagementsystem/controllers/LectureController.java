package pl.sda.trainingmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.trainingmanagementsystem.domain.Lecture;
import pl.sda.trainingmanagementsystem.service.LectureService;

@RequestMapping("/lecture")
@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @RequestMapping("/list")
    public String getCourses (Model model){
        model.addAttribute("lectures", lectureService.listAllLecture());
        return "lectures";
    }

    @RequestMapping("/{id}")
    public String getLectureBy(@PathVariable Integer id, Model model){
        model.addAttribute("lecture", lectureService.getById(id));
        return "lecture";
    }

    @RequestMapping("/delete/{id}")
    public String getLectureBy(@PathVariable Integer id){
        lectureService.delete(id);
        return "redirect:/lectures";
    }

    @RequestMapping("/edit/{id}")
    public String editLecture(@PathVariable Integer id, Model model){
        model.addAttribute("lecture", lectureService.getById(id));
        return "lectureForm";
    }

    @RequestMapping("/new")
    public String newLecture(Model model){
        model.addAttribute("lecture", new Lecture());
        return "lectureForm";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveLecture(Lecture lecture){
        Lecture newOne = lectureService.save(lecture);
        return "redirect:/lecture/" + newOne.getLectureId();
    }
}


