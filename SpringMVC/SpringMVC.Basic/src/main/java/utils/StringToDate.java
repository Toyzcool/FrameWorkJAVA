package utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String, Date> {
    @Override
//    s为传进来的参数
    public Date convert(String s) {
        if (s == null){
            throw new RuntimeException("请输入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
