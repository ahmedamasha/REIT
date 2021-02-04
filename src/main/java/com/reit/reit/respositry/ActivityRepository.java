package com.reit.reit.respositry;

import com.reit.reit.model.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityRepository extends PagingAndSortingRepository<Activity, Integer> {
}
