package com.reit.reit.service.impl;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.exception.ResourceNotFoundException;
import com.reit.reit.model.Activity;
import com.reit.reit.model.Building;
import com.reit.reit.model.User;
import com.reit.reit.response.UserActivities;
import com.reit.reit.respositry.BuildingRepository;
import com.reit.reit.respositry.UserRepository;
import com.reit.reit.service.BuildingService;
import com.reit.reit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> findAll(Integer pageNumber, Integer rowPerPage) {
        List<User> user = new ArrayList<>();
        userRepository.findAll(PageRequest.of(pageNumber - 1, rowPerPage)).forEach(user::add);
        return user;
    }

    @Override
    public List<UserActivities> findUsersActivityCount() {
        return userRepository.findUsersActivityCount();
    }

    public User findById(Integer id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user==null) {
            throw new ResourceNotFoundException("Cannot find Building with id: " + id);
        }
        else return user;
    }

    private boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    public User save(User user) throws BadResourceException, ResourceAlreadyExistsException {
        if (!StringUtils.isEmpty(user.getName())) {
            if (user.getId() != null && existsById(user.getId())) {
                throw new ResourceAlreadyExistsException("Building with id: " + user.getId() +
                        " already exists");
            }
            return userRepository.save(user);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save buildings");
            exc.addErrorMessage("buildings is null or empty");
            throw exc;
        }
    }
}
