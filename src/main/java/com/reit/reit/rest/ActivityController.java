package com.reit.reit.rest;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.model.Activity;
import com.reit.reit.model.Building;
import com.reit.reit.service.ActivityService;
import com.reit.reit.service.BuildingService;
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
            @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        return ResponseEntity.ok(activityService.findAll(pageNumber, ROW_PER_PAGE));
    }
}
