package project3.backend.helper.helper;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {

    public Date getDateTimeNow(){

        Date date=new Date();
        return date;
    }

    public String formatIntoSqlDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        String sqlDate = simpleDateFormat.format(date);
        return sqlDate;

    }
}
