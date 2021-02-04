package com.reit.reit.respositry;

import com.reit.reit.model.Building;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BuildingRepository extends PagingAndSortingRepository<Building, Integer> {
}
