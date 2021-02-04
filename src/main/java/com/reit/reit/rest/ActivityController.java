package com.reit.reit.rest;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.model.Activity;
import com.reit.reit.model.Building;
import com.reit.reit.service.ActivityService;
import com.reit.reit.service.BuildingService;
import com.reit.reit.service.UserService;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/activities")
@Validated
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    private final int ROW_PER_PAGE = 5;

    @PostMapping
    public Activity add(@RequestBody @Valid @NotNull Activity activity) throws BadResourceException, ResourceAlreadyExistsException {
        return activityService.save(activity);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Activity>> findAll(
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            @RequestParam(required = false) String title) {
        return ResponseEntity.ok(activityService.findAll(title,pageNumber, ROW_PER_PAGE));
    }


    @GetMapping(value = "/user/{asignId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Activity>> findAllActivitiesByUser(@PathVariable(required = false) Integer asignId) {
        return ResponseEntity.ok(activityService.findAllActivitiesByUser(asignId));
    }

    @GetMapping(value = "/building/{buldingId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Activity>> findAllActivitiesByBuilding(@PathVariable(required = false) Integer buldingId) {
        return ResponseEntity.ok(activityService.findAllActivitiesByBuilding(buldingId));
    }
}
