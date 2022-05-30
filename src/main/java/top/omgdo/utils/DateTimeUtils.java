package top.omgdo.utils;

import top.omgdo.pojo.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {


    /**
     *
     * @param time DATE_TIME  yyyy-MM-dd hh:mm:ss
     *             DATE   yyyy-MM-dd
     *             TIME   hh:mm:ss
     *
     *
     * @return  返回一个字符串格式的当前时间
     */
    public static String getCurrentTime(DateTime time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(time.getPatten());
        return simpleDateFormat.format(new Date());
    };


}
