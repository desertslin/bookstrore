package com.deserts.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ClassName WebUtils
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/13 22:39
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
