package com.reit.reit.rest;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.model.User;
import com.reit.reit.response.UserActivities;
import com.reit.reit.service.UserService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user")
@Validated
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    private final int ROW_PER_PAGE = 5;

    @PostMapping
    public User add(@RequestBody @Valid @NotNull User user) throws BadResourceException, ResourceAlreadyExistsException {
        return userService.save(user);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAll(
            @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        return ResponseEntity.ok(userService.findAll(pageNumber, ROW_PER_PAGE));
    }

    @GetMapping(value = "/activities" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserActivities>> gatAllTasks() {
        return ResponseEntity.ok(userService.findUsersActivityCount());
    }
}
