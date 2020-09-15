package com.wuning.utils;

import com.wuning.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author wu
 * @date 2020-04-21 09:21
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {

            System.out.println("注册前" + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注册后" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
