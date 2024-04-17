package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Abror Abdukadirov
 */
@Controller
public class TestController {


    @GetMapping("/")
    public String showMainPage(Model model) {
        List<Person> persons = Arrays.asList(
                new Person("test 1", "test 1"),
                new Person("test 2", "test 2")
        );

        model.addAttribute("form", new Form(persons));
        return "test";
    }

    @PostMapping("/editpersons")
    public String saveEditPersons(@ModelAttribute Form form) {

        form.getPersonList().forEach(System.out::println);

        return "test";
    }

    public static class Form {
        List<Person> personList;

        public Form() {
        }

        public Form(List<Person> personList) {
            this.personList = personList;
        }

        public List<Person> getPersonList() {
            return personList;
        }

        public void setPersonList(List<Person> personList) {
            this.personList = personList;
        }

        public void setPersonList(ArrayList<Person> personList) {
            this.personList = personList;
        }
    }

    public static class Person {
        private String name;
        private String age;

        public Person() {
        }

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name=" + name +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
