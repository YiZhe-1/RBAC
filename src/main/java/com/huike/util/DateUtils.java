package com.huike.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jy
 * @version 1.0
 * @date 2022/2/14 16:04
 * 时间转换工具类
 */
public class DateUtils {

    /**
     * 将Long类型转换为Date类型
     * @param inputTime
     * @return
     */
    public static Date getDate(Long inputTime){
        Date date = new Date();
        date.setTime(inputTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String inputTimeStrr = sdf.format(date);
        try {
            return sdf.parse(inputTimeStrr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将String类型转换为Date类型
     * @param traceTime
     * @return
     */
    public static Date getDate2(String traceTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (traceTime != null && !"".equals(traceTime)){
                return sdf.parse(traceTime);
            }
            else {
                System.out.println("时间格式有误！");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
