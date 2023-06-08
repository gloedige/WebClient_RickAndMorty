package de.iav.webclient_rnm.controller;

import de.iav.webclient_rnm.model.Student;
import de.iav.webclient_rnm.service.Studentservice;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    private final Studentservice studentservice;

    public StudentController(Studentservice studentservice) {
        this.studentservice = studentservice;
    }

    @PostMapping
    public Student postSingleStudent(@RequestBody Student student){
        return studentservice.postSingleStudent(student);
    }
}
