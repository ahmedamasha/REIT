package com.reit.reit.service.impl;

import com.reit.reit.exception.BadResourceException;
import com.reit.reit.exception.ResourceAlreadyExistsException;
import com.reit.reit.exception.ResourceNotFoundException;
import com.reit.reit.model.Building;
import com.reit.reit.respositry.BuildingRepository;
import com.reit.reit.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    public BuildingRepository buildingRepository;

    public List<Building> findAll(Integer pageNumber, Integer rowPerPage) {
        List<Building> buildings = new ArrayList<>();
        buildingRepository.findAll(PageRequest.of(pageNumber - 1, rowPerPage)).forEach(buildings::add);
        return buildings;
    }

    public Building findById(Integer id) throws ResourceNotFoundException {
        Building building = buildingRepository.findById(id).orElse(null);
        if (building==null) {
            throw new ResourceNotFoundException("Cannot find Building with id: " + id);
        }
        else return building;
    }

    private boolean existsById(Integer id) {
        return buildingRepository.existsById(id);
    }

    public Building save(Building building) throws BadResourceException, ResourceAlreadyExistsException {
        if (!StringUtils.isEmpty(building.getName())) {
            if (building.getId() != null && existsById(building.getId())) {
                throw new ResourceAlreadyExistsException("Building with id: " + building.getId() +
                        " already exists");
            }
            return buildingRepository.save(building);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save buildings");
            exc.addErrorMessage("buildings is null or empty");
            throw exc;
        }
    }
}
