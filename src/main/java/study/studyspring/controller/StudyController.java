package study.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudyController {

    @GetMapping("study")
    public String study(Model model) {
        model.addAttribute("data","study!!");
        return "study";
    }

    @GetMapping("study-mvc")
    public String studyMvc(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "study-template";
    }
}
