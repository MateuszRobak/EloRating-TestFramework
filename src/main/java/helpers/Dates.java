package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates {
    public static String addHoursToCurrentHour(int hour) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.HOUR, hour);
        dt = c.getTime();
        SimpleDateFormat HH = new SimpleDateFormat("HH");
        return HH.format(dt);
    }

    public static String addMinutes(int minute) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.set(Calendar.MINUTE,0);
        c.add(Calendar.MINUTE, minute);
        dt = c.getTime();
        SimpleDateFormat mm = new SimpleDateFormat("mm");
        return mm.format(dt);
    }
}
