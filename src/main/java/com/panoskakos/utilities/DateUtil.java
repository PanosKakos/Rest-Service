package com.panoskakos.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {


    public static boolean dateUtils( String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime offerExpiration = LocalDateTime.parse( date , formatter  );

        return  offerExpiration.isBefore(LocalDateTime.now());

    }

}