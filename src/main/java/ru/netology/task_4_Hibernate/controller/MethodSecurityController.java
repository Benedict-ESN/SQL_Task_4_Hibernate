package ru.netology.task_4_Hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodSecurityController {

    @Secured("ROLE_READ")
    @GetMapping("/secure/read")
    public String readAccess() {
        return "Access granted to READ role";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/secure/write")
    public String writeAccess() {
        return "Access granted to WRITE role";
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/secure/write-or-delete")
    public String writeOrDeleteAccess() {
        return "Access granted to WRITE or DELETE role";
    }

    @PreAuthorize("#username == authentication.name")
    @GetMapping("/secure/self")
    public String selfAccess(@RequestParam("username") String username) {
        return "Access granted to user: " + username;
    }
}
