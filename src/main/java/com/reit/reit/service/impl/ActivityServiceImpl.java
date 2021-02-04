package com.reit.reit.service.impl;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.exception.ResourceNotFoundException;
import com.reit.reit.model.Activity;
import com.reit.reit.respositry.ActivityRepository;
import com.reit.reit.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    public ActivityRepository activityRepository;

    public List<Activity> findAll(Integer pageNumber, Integer rowPerPage) {
        List<Activity> activity = new ArrayList<>();
        activityRepository.findAll(PageRequest.of(pageNumber - 1, rowPerPage)).forEach(activity::add);
        return activity;
    }

    public Activity findById(Integer id) throws ResourceNotFoundException {
        Activity activity = activityRepository.findById(id).orElse(null);
        if (activity == null) {
            throw new ResourceNotFoundException("Cannot find activity with id: " + id);
        } else return activity;
    }

    private boolean existsById(Integer id) {
        return activityRepository.existsById(id);
    }

    public Activity save(Activity activity) throws BadResourceException, ResourceAlreadyExistsException {
        if (!StringUtils.isEmpty(activity.getActivityName())) {
            if (activity.getId() != null && existsById(activity.getId())) {
                throw new ResourceAlreadyExistsException("activity with id: " + activity.getId() +
                        " already exists");
            }
            return activityRepository.save(activity);
        } else {
            BadResourceException exc = new BadResourceException("Failed to save buildings");
            exc.addErrorMessage("activity is null or empty");
            throw exc;
        }
    }
}
