package com.xy.studyapp.repository.security;

import com.xy.studyapp.entity.other.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface BannerRepository extends JpaRepository<Banner, Long> {

    public List<Banner> findAll();
}
