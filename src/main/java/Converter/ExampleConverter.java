package Converter;


import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class ExampleConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {

        return new Date();
    }
}
