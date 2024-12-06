package javaLocalDateLocalTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DateTimeTasks {
    public static void main(String[] args) {
        //task1
        LocalDate d1 = LocalDate.now();
        String df1 = d1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalTime t1 = LocalTime.now();
        System.out.println(df1 + " " + t1);
        /////////////////////////////////////////////////////////////////////
        //task2
        LocalDate dd = LocalDate.now();
        LocalDate dd2 = LocalDate.of(2020, 1, 1);
        compareDate(dd, dd2);
        /////////////////////////////////////////////////////////////////////
        //task3
        daysToNY(LocalDate.now());
        /////////////////////////////////////////////////////////////////////
        //task4
        isLeapYear(LocalDate.now());
        /////////////////////////////////////////////////////////////////////
        //task5
        System.out.println(countWeekend(YearMonth.now()));
        /////////////////////////////////////////////////////////////////////
        //task6
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
        }
        countTime(start);
        ////////////////////////////////////////////////////////////////////
        //task7
        System.out.println(parseDate("04-12-2024"));
        ////////////////////////////////////////////////////////////////////
        //task8
        convertUTC(ZonedDateTime.now());
        /////////////////////////////////////////////////////////////////////
        //task9
        System.out.println(calAge(LocalDate.of(2006, 4, 15)));
        /////////////////////////////////////////////////////////////////////
        //task10//
        calendarForMonth(1, 2020);
        ////////////////////////////////////////////////////////////////////
        //task11
        System.out.println(randomDate(LocalDate.of(2020, 1, 1), LocalDate.now()));
        ////////////////////////////////////////////////////////////////////
        //task12
        LocalDateTime mom = LocalDateTime.of(2030, 12, 12, 0, 0, 0);
        getTimeUntilDate(mom);
        ////////////////////////////////////////////////////////////////////
        //task13
        LocalDateTime dt = LocalDateTime.of(2024, 12, 2, 0, 0);
        System.out.println(getWorksHours(dt, LocalDateTime.now()));
        ////////////////////////////////////////////////////////////////////
        //task14
        System.out.println(convertDateToString(LocalDate.now()));
        ////////////////////////////////////////////////////////////////////
        //task15
        System.out.println(returnRusDayName(LocalDate.now()));
    }
    public static void compareDate(LocalDate date1, LocalDate date2) {
        if (date1.isAfter(date2)) {
            System.out.println(date1 + " после " + date2);
        } else if (date1.isBefore(date2)) {
            System.out.println(date1 + " до " + date2);
        } else {
            System.out.println(date1 + " равно " + date2);
        }
    }
    public static void daysToNY(LocalDate d) {
        LocalDate newYear = LocalDate.of(d.getYear() + 1, 1, 1);
        System.out.println(ChronoUnit.DAYS.between(d, newYear));
    }
    public static void isLeapYear(LocalDate date) {
        int year = date.getYear();
        if (year % 4 == 0) {
            System.out.println("Високосный");
        }
        else {
            System.out.println("Не високосный");
        }
    }
    public static int countWeekend(YearMonth yearMonth) {
        int cnt = 0;
        for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
            DayOfWeek currentDay = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), i).getDayOfWeek();
            if (currentDay.equals(DayOfWeek.SATURDAY) || currentDay.equals(DayOfWeek.SUNDAY)) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void countTime(long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " миллисекунд");
    }
    public static String parseDate(String str) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate result = LocalDate.parse(str, pattern);
        return result.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
    public static void convertUTC(ZonedDateTime time) {
        ZoneId targetZone = ZoneId.of("America/New_York");
        ZonedDateTime convertedTime = time.withZoneSameInstant(targetZone);
        System.out.println("Исходное время (UTC): " + time);
        System.out.println("Конвертированное время (America/New_York): " + convertedTime);
    }
    public static int calAge(LocalDate birth) {
        if (birth != null) {
            return Period.between(birth, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public static void calendarForMonth(int month, int year) {
        Calendar calendar = new GregorianCalendar(year, month, 1);
        System.out.println(calendar.get(Calendar.MONTH));
    }//

    public static LocalDate randomDate(LocalDate firstDate, LocalDate secondDate) {
        Random random = new Random();
        List<LocalDate> dates = new ArrayList<>();

        while (!firstDate.isAfter(secondDate)) {
            dates.add(firstDate);
            firstDate = firstDate.plusDays(1);
        }
        return dates.get(random.nextInt(dates.size()));
    }
    public static void getTimeUntilDate(LocalDateTime moment) {
        ZonedDateTime targetZonedDateTime = moment.atZone(ZoneId.systemDefault());
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();

        Duration duration = Duration.between(currentZonedDateTime, targetZonedDateTime);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.printf("%d дней, %d часов, %d минут, %d секунд%n", days, hours, minutes, seconds);
    }
    public static int getWorksHours(LocalDateTime date1, LocalDateTime date2) {
        int cnt = 0;
        while (date1.isBefore(date2)) {
            if (date1.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date1.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date1.getHour() > 18 || date1.getHour() < 10) {
                date1 = date1.plusHours(1);
                continue;
            }
            cnt++;
            date1 = date1.plusHours(1);
        }
        return cnt;
    }
    public static String convertDateToString(LocalDate date) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zdt = date.atStartOfDay(zone);
        return formattedDate + " " + zone;
    }
    public static String returnRusDayName(LocalDate date) {
        return switch (date.getDayOfWeek()) {
            case MONDAY -> "Понедельник";
            case TUESDAY -> "Вторник";
            case WEDNESDAY -> "Среда";
            case THURSDAY -> "Четверг";
            case FRIDAY -> "Пятница";
            case SATURDAY -> "Суббота";
            case SUNDAY -> "Воскресенье";
        };
    }
}
