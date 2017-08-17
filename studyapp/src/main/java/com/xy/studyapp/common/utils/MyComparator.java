package com.xy.studyapp.common.utils;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by xy on 2017/7/23.
 */
public class MyComparator  implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Date date1;
        Date date2;
        Class class1=o1.getClass();
        Class class2=o2.getClass();
        try {
            Method m1 = class1.getDeclaredMethod("getCreateTime");
            Method m2 = class2.getDeclaredMethod("getCreateTime");
            date1= (Date) m1.invoke(o1);
            date2=(Date)m2.invoke(o2);
            if(date1.after(date2)){
                return -1;
            }
            if(date1.before(date2)){
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
