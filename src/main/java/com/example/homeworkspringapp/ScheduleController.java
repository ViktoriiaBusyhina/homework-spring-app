package com.example.homeworkspringapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleController {

    private final List<String> schedule;

    public ScheduleController() {
        schedule = new ArrayList<>();
        schedule.add("Java");
        schedule.add("Algorithms");
        schedule.add("GenTech");
        schedule.add("Git");
        schedule.add("Frontend");
        schedule.add("Linux");
        schedule.add("Продлёнка");
        schedule.add("SQL");
    }

    public ScheduleController(List<String> schedule) {
        this.schedule = schedule;
    }

    @GetMapping(value = "/schedule")
    public List<String> getSchedule (){
        return schedule;
    }

    @PostMapping(value = "/schedule")
    public String addLesson(@RequestBody String lesson) {
        schedule.add(lesson);
        return lesson;
    }

    @DeleteMapping(value = "/schedule/{id}")
    public void deleteLesson(@PathVariable String id) {
        int idNumber = Integer.parseInt(id);
        schedule.remove(idNumber);
    }

    @PutMapping(value = "schedule/{id}")
    public void updateLesson(@RequestBody String lesson, @PathVariable String id) {
        int idNumber = Integer.parseInt(id);
        schedule.set(idNumber, lesson);
    }

    @GetMapping(value = "/schedule/{id}")
    public String getLessonById(@PathVariable String id) {
        int idNumber = Integer.parseInt(id);
        return schedule.get(idNumber);
    }


}
