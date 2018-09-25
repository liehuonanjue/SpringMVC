package service;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Myconvert implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
//        根据用户输入的创建不同的sdf
        SimpleDateFormat simpleDateFormat = getDate(source);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    private SimpleDateFormat getDate(String source) {
        SimpleDateFormat sdf = null;
        if (Pattern.matches("\\d{4}/\\d{2}/\\d{2}", source)) {
            sdf = new SimpleDateFormat("yyyy/MM/dd");
        } else if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", source)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if (Pattern.matches("\\d{4}\\d{2}\\d{2}", source)) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        } else {
            throw new TypeMismatchException("", Date.class);
        }
        return sdf;

    }
}
