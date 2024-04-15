package com.AtlasVoteGate.AtlasVoteGate.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    public static String formatDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    // Add other date-related utility methods here
}
