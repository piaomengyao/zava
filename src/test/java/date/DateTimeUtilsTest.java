package date;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author Abel
 * @date 2018/10/23
 */
public class DateTimeUtilsTest {

    private long interval = 363;
    private LocalDate thatDay = LocalDate.of(1992, 3, 1);
    private LocalDate thisDay = LocalDate.of(1993, 2, 27);
    private Date thatDayDate = getDate("19920301", "yyyyMMdd");
    private Date thisDayDate = getDate("19930227", "yyyyMMdd");
    private String thatDayStr = "19920301";
    private String thisDayStr = "19930227";
    private String yyyyMMdd = "yyyyMMdd";

    @Test
    public void intervalLocalDateTest() {
        System.out.println(DateTimeUtils.intervalLocalDate(thatDay));
        System.out.println(DateTimeUtils.intervalLocalDate(thatDayStr));
        Assert.assertEquals(interval, DateTimeUtils.intervalLocalDate(thatDay, thisDay));
    }

    @Test
    public void intervalDateTest() {
        Assert.assertEquals(interval, DateTimeUtils.intervalDate(thatDayDate, thisDayDate));
    }

    @Test
    public void intervalYyyyMmDdTest() {
        Assert.assertEquals(interval, DateTimeUtils.intervalYyyyMmDd(thatDayStr, thisDayStr));
    }

    private Date getDate(String date, String pattern) {
        Objects.requireNonNull(date);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}