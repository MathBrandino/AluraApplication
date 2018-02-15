package br.com.caelum.aluraapplication.database.converter;

import android.arch.persistence.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class Converters {


    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


    @TypeConverter
    public static Calendar convertToCalendar(String data) {
        try {

            Calendar instance = Calendar.getInstance();

            Date date = format.parse(data);

            instance.setTime(date);

            return instance;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    @TypeConverter
    public static String convertToString(Calendar data) {

        String dataFormatada = format.format(data.getTime());

        return dataFormatada;

    }

    @TypeConverter
    public static Date convertToDate(String data) {
        try {
            Date date = format.parse(data);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @TypeConverter
    public static String convertToString(Date data) {

        String dataFormatada = format.format(data);

        return dataFormatada;

    }
}
