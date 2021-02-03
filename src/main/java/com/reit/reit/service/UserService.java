package com.reit.reit.service;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.model.Building;
import com.reit.reit.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll(Integer pageNumber, Integer rowPerPage);

    User save(User user) throws BadResourceException, ResourceAlreadyExistsException;
}
