package util;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/3.
 */
public class DateUtil {

    //格式化输出日期
    public static String format(java.util.Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new java.text.SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    //返回年份
    public static int getYear(java.util.Date date){
        java.util.Calendar c=java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    //返回月份
    public static int getMonth(java.util.Date date){
        java.util.Calendar c =java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH)+1;
    }

    //返回月份中的第几天
    public static int getDay(java.util.Date date){
        java.util.Calendar c =java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    //返回小时
    public static int getHour(java.util.Date date){
        java.util.Calendar c =java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    //返回分钟
    public static int getMinute(java.util.Date date){
        java.util.Calendar c =java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    //返回秒
    public static int getSecond(java.util.Date date){
        java.util.Calendar c =java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

}