package com.developforpeople.timesheetmanager.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.annotation.WebListener;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    WebClient webClient;

    @GetMapping("/{id}")
    public Flux<Object> getProjectName(@PathVariable("id") String id, @AuthenticationPrincipal OAuth2User principal) {
        System.out.println(principal);
        return webClient.get()
            .uri("http://localhost:8082/name") // Send request to resource server
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(Object.class);
    }

    static class Todo {
        String userId;
        int id;
        String title;
        boolean completed;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }
}
