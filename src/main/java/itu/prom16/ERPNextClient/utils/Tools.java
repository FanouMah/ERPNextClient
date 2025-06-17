package itu.prom16.ERPNextClient.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static List<String> StartMonthsBetweenTwoMonth(String month1, String month2) throws Exception  {
        YearMonth startMonth = YearMonth.parse(month1);
        YearMonth endMonth = YearMonth.parse(month2);

        List<LocalDate> dates = new ArrayList<>();
        List<String> strDates = new ArrayList<>();

        YearMonth current = startMonth;
        while (!current.isAfter(endMonth)) {
            dates.add(current.atDay(1));
            current = current.plusMonths(1);
        }

        for (LocalDate date : dates) {
            strDates.add(date.toString());
        }

        return strDates;
    }
}
