package com.reit.reit.service;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.model.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> findAll(Integer pageNumber, Integer rowPerPage);

    Activity save(Activity activity) throws BadResourceException, ResourceAlreadyExistsException;
}
