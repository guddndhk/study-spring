package study.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudyController {

    @GetMapping("study")
    public String study(Model model) {
        model.addAttribute("data", "study!!");
        return "study";
    }

    @GetMapping("study-mvc")
    public String studyMvc(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "study-template";
    }

    @GetMapping("study-string")
    @ResponseBody
    public String studyString(@RequestParam("name") String name) {
        return "study" + name;
    }

    @GetMapping("study-api")
    @ResponseBody
    public Study studyApi(@RequestParam("name") String name) {
        Study study = new Study();
        study.setName(name);
        return study;
    }

    static class Study {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
