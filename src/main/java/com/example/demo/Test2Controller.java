package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author Abror Abdukadirov
 */
@Controller
public class Test2Controller {

    @GetMapping("/test2")
    public String showMainPage(Model model) {
        List<TestController.Person> persons = Arrays.asList(
                new TestController.Person("test 1", "test 1"),
                new TestController.Person("test 2", "test 2")
        );

        model.addAttribute("form", new TestController.Form(persons));
        return "test2";
    }

    @PostMapping("/tasks/approve")
    public String approveTasks(@ModelAttribute TestController.Form form) {

        form.getPersonList().forEach(System.out::println);

        return "test2";
    }
}
