package com.developforpeople.timesheetresourceserver.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController()
public class ProjectController {
    @GetMapping("name")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public ResponseEntity<Todo> testMethod(Principal principal) {
        Todo todo = new Todo();
        todo.userId = principal.getName();
        todo.id = 4;
        todo.title = "TTle";
        todo.completed = true;
        return ResponseEntity.accepted().body(todo);
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
