package com.xy.studyapp.service;

import com.xy.studyapp.entity.other.Banner;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
public interface BannerService {

    List<Banner> findAll() throws Exception;

    void insert(Banner banner)throws Exception;

    void delete(long id)throws Exception;
}
