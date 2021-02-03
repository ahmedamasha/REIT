package com.reit.reit.service;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.model.Building;

import java.util.List;

public interface UserService {

    List<Building> findAll(Integer pageNumber, Integer rowPerPage);

    Building save(Building building) throws BadResourceException, ResourceAlreadyExistsException;
}
