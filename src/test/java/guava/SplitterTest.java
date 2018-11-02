package guava;

import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class SplitterTest {
    /*
        on():指定分隔符来分割字符串
        limit():当分割的子字符串达到了limit个时则停止分割
        fixedLength():根据长度来拆分字符串
        trimResults():去掉子串中的空格
        omitEmptyStrings():去掉空的子串
        withKeyValueSeparator():要分割的字符串中key和value间的分隔符,分割后的子串中key和value间的分隔符默认是=
    */
    @Test
    public void splitterTest() {
        System.out.println(Splitter.on("-").limit(3).trimResults().split(" a-b-c-d"));
        System.out.println(Splitter.fixedLength(3).split("1 2 3 4 5 6 7 8 9"));
        System.out.println(Splitter.on(" ").omitEmptyStrings().splitToList("1  2 3"));
        System.out.println(Splitter.on(",").omitEmptyStrings().split("1,,,,2,,,3"));//[1, 2, 3]
        System.out.println(Splitter.on(" ").trimResults().split("1 2 3")); //[1, 2, 3],默认的连接符是,
        System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3"));
    }
}