package com.reit.reit.respositry;

import com.reit.reit.model.User;
import com.reit.reit.response.UserActivities;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    @Query(value = "select   count(a.id) as totalActivities  ,u.name as userName from activities a inner join users u on u.id = a.user_id group by  u.name" , nativeQuery = true )
    List<UserActivities> findUsersActivityCount();
}
