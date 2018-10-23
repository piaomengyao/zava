package date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 工具类
 *
 * @author Abel
 * @date 2018/10/23
 */
class DateTimeUtils {

    /**
     * 当前日期与给定日期的间隔天数
     *
     * @param endDate 指定日期
     * @return 间隔天数
     */
    static long intervalLocalDate(LocalDate endDate) {
        return Math.abs(LocalDate.now().until(endDate, ChronoUnit.DAYS));
    }

    /**
     * 两个日期的间隔天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 间隔天数
     */
    static long intervalLocalDate(LocalDate startDate, LocalDate endDate) {
        return Math.abs(startDate.until(endDate, ChronoUnit.DAYS));
    }

    /**
     * 两个Date类型日期的间隔天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 间隔天数
     */
    static long intervalDate(Date startDate, Date endDate) {
        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return intervalLocalDate(startLocalDate, endLocalDate);
    }

    /**
     * 计算两个yyyyMMdd格式日期的间隔天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 间隔天数
     */
    static long intervalYyyyMmDd(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, formatter);
        return intervalLocalDate(startLocalDate, endLocalDate);
    }
}