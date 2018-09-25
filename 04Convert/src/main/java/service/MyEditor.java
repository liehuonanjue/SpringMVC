package service;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MyEditor extends PropertiesEditor {
    @Override
    public void setAsText(String source) throws IllegalArgumentException {
//        根据用户输入的创建不同的sdf
        System.out.println(2222);
        SimpleDateFormat simpleDateFormat = getDate(source);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
            setValue(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private SimpleDateFormat getDate(String source) {

        SimpleDateFormat sdf = null;
        System.out.println(3333);
        if (Pattern.matches("\\d{4}/\\d{2}/\\d{2}", source)) {
            System.out.println("pp");
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
