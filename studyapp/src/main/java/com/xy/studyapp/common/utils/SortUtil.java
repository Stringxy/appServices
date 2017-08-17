package com.xy.studyapp.common.utils;

import org.springframework.data.domain.Sort;

/**
 * Created by xy on 2017/7/23.
 */
public class SortUtil {
    public static Sort basicSort() {
        return basicSort("desc", "createTime");
    }

    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }
}
