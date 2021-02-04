package com.reit.reit.respositry;

import com.reit.reit.model.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ActivityRepository extends PagingAndSortingRepository<Activity, Integer> {

    List<Activity> findActivitiesByActivityNameContains(String name);

    List<Activity> findAllByUser_id(Integer asignId);

    List<Activity> findAllByBuilding_id(Integer buldingId);

}
