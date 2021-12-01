package com.jxd.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Web工具类
 * @author jxd
 * @date 2021/11/22 10:45
 */
public class WebUtils<T> {
    /**
     * 将request中的数据赋值给对象
     * @param request request对象
     * @param t 要赋值的对象
     * @return 将request中的数据赋值到对象后的对象
     */
    public static <T> T param2bean(HttpServletRequest request, T t) {
        // 获取对象的所有属性
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 获取每一个属性的属性名
            String fieldName = field.getName();
            String value = request.getParameter(fieldName);
            try {
                BeanUtils.setProperty(t, fieldName, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    /**
     * 和param2bean功能相同，实现方法不同
     * @param request
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T param2bean1(HttpServletRequest request, T t) {
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(t, map);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("WebUtils中的param2bean1方法出错");
        }
        return t;
    }

}
