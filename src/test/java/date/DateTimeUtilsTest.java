package date;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Abel
 * @date 2018/10/23
 */
public class DateTimeUtilsTest {

    private long interval = 2551;
    private LocalDate localDate1 = LocalDate.of(2008, 8, 8);
    private LocalDate localDate2 = LocalDate.of(2015, 2, 2);
    private Date date1 = DateTimeUtils.parseYyyyMmDdToDate("20080808");
    private Date date2 = DateTimeUtils.parseYyyyMmDdToDate("20150202");
    private String yyyyMmDd1 = "20080808";
    private String yyyyMmDd2 = "20150202";

    public DateTimeUtilsTest() throws ParseException {
    }

    @Test
    public void parseYyyyMmDdToLocalDateTest() {
        System.out.println(DateTimeUtils.parseYyyyMmDdToLocalDate(yyyyMmDd1));
    }

    @Test
    public void parseLocalDateToYyyyMmDdTest() {
        Assert.assertEquals(yyyyMmDd1, DateTimeUtils.parseLocalDateToYyyyMmDd(localDate1));
    }

    @Test
    public void intervalLocalDateTest() {
        System.out.println(DateTimeUtils.intervalLocalDate(localDate1));
        System.out.println(DateTimeUtils.intervalLocalDate(yyyyMmDd1));
        Assert.assertEquals(interval, DateTimeUtils.intervalLocalDate(localDate1, localDate2));
    }

    @Test
    public void intervalDateTest() {
        Assert.assertEquals(interval, DateTimeUtils.intervalDate(date1, date2));
    }

    @Test
    public void intervalYyyyMmDdTest() {
        Assert.assertEquals(interval, DateTimeUtils.intervalYyyyMmDd(yyyyMmDd1, yyyyMmDd2));
    }

    @Test
    public void traversingTwoYyyyMmDdTest() {
        List<String> traversingList = DateTimeUtils.traversingTwoYyyyMmDd(yyyyMmDd1, yyyyMmDd2);
        Optional.ofNullable(traversingList)
                .orElseGet(ArrayList::new)
                .forEach(System.out::println);
    }
}
