package com.xy.studyapp.security.support;

import com.xy.studyapp.entity.security.Resource;
import com.xy.studyapp.entity.security.Role;
import com.xy.studyapp.repository.security.ResourceRepository;
import com.xy.studyapp.repository.security.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by xy on 2017/6/26.
 */
public class CustomInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource {
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @PostConstruct
    private void loadResourceDefine() {
        List<Role> list = roleRepository.findAll();
        List<String> query = new ArrayList<String>();
        if (list != null && list.size() > 0) {
            for (Role sr : list) {
                String name = String.valueOf(sr.getId());
                query.add(name);
            }
        }
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

        for (String auth : query) {
            ConfigAttribute ca = new SecurityConfig(auth);
            //List<Map<String,Object>> query1 = sResourceVODao.findByRoleName(auth);
            List<String> query1 = new ArrayList<String>();
            List<Resource> resources = resourceRepository.findByRoleId(auth);
            if (resources != null && resources.size() > 0) {
                for (Resource resource : resources) {

                    query1.add(resource.getUrl());
                }
            }
            for (String res : query1) {
                String url = res;

                if (resourceMap.containsKey(url)) {

                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
            }
        }
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {System.out.println("nwuidhwuiehdfu");
       FilterInvocation filterInvocation = (FilterInvocation) object;
        if (resourceMap == null) {
            loadResourceDefine();
        }
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourceMap.get(resURL);
            }
        }

        return null;
    }
    @Override
    public boolean supports(Class<?> arg0) {

        return true;
    }
}
