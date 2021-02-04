package com.reit.reit.service;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.model.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> findAll(String title, Integer pageNumber, Integer rowPerPage);

    List<Activity> findAllActivitiesByUser(Integer assignId);

    List<Activity> findAllActivitiesByBuilding(Integer assignId);

    Activity save(Activity activity) throws BadResourceException, ResourceAlreadyExistsException;
}
