package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.security.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xy on 2017/6/26.
 */
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Query(value = "select r.resource_id,r.resource_url,r.name from t_resource r,t_resource_role rr where r.resource_id=rr.resource_id and rr.role_id=:roleId",nativeQuery = true)
    List<Resource> findByRoleId(@Param("roleId") String roleId);
}
