package pl.maciejdudek.project.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejdudek.project.model.DTO.CredentialsDTO;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody CredentialsDTO credentials) {
    }
}