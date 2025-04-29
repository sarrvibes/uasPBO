package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String formatJam(long milis) {
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }
}
