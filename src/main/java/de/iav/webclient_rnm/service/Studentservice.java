package de.iav.webclient_rnm.service;
import de.iav.webclient_rnm.controller.StudentController;
import de.iav.webclient_rnm.model.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;
import java.util.Objects;

@Service
public class Studentservice {

    WebClient webClient = WebClient.create("http://localhost:8080");

    public Student postSingleStudent(Student student) {
        Student response = webClient.post()
                .uri("/api/students")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(student)
                .retrieve()
                .toEntity(Student.class)
                .block()
                .getBody();
        Objects.requireNonNull(response);
        return response;
    }
}
