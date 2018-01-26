package com.xy.studyapp.service.impl;

import com.xy.studyapp.entity.other.Banner;
import com.xy.studyapp.repository.security.BannerRepository;
import com.xy.studyapp.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xy on 2017/7/7.
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    @Override
    public List<Banner> findAll() throws Exception {
        return bannerRepository.findAll();
    }

    @Override
    public void insert(Banner banner) throws Exception {
        bannerRepository.save(banner);
    }

    @Override
    public void delete(long id) throws Exception {
        bannerRepository.delete(id);
    }
}
