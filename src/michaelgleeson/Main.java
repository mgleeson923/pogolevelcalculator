package michaelgleeson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int xpToDate;
        String startDate;
        long totalXP = 20000000;

        System.out.println("Enter a date in the following format: dd-Mmm-YYYY");
        startDate = scnr.nextLine();

        System.out.println("Input your current total XP (no commas): ");
        xpToDate = scnr.nextInt();

        currentUserLevel(xpToDate);

        calculateDaysRemaining(xpToDate, startDate, totalXP);

    }

    public static void calculateDaysRemaining(int xpToDate, String startDate, long totalXP) {
        long xpPerDay;
        long xpRemaining;
        long daysRemaining;

        xpPerDay = xpToDate / calculateDate(startDate);
        xpRemaining = totalXP - xpToDate;
        daysRemaining = xpRemaining/xpPerDay;

        System.out.println("Your XP per Day is: " + xpPerDay);
        System.out.println("You have " + xpRemaining + " XP remaining!");
        System.out.println("And you only have " + daysRemaining + " days remaining until you hit level 40!");
    }

    public static int currentUserLevel(Integer xpToDate) {
        int userLevel = 0;
        Map<Integer, Integer> levels = new HashMap();
        levels.put(1, 0);
        levels.put(2, 1000);
        levels.put(3, 3000);
        levels.put(4, 6000);
        levels.put(5, 10000);
        levels.put(6, 15000);
        levels.put(7, 21000);
        levels.put(8, 28000);
        levels.put(9, 36000);
        levels.put(10, 45000);
        levels.put(11, 55000);
        levels.put(12, 65000);
        levels.put(13, 75000);
        levels.put(14, 85000);
        levels.put(15, 100000);
        levels.put(16, 120000);
        levels.put(17, 140000);
        levels.put(18, 160000);
        levels.put(19, 185000);
        levels.put(20, 210000);
        levels.put(21, 260000);
        levels.put(22, 335000);
        levels.put(23, 435000);
        levels.put(24, 560000);
        levels.put(25, 710000);
        levels.put(26, 900000);
        levels.put(27, 1100000);
        levels.put(28, 1350000);
        levels.put(29, 1650000);
        levels.put(30, 2000000);
        levels.put(31, 2500000);
        levels.put(32, 3000000);
        levels.put(33, 3750000);
        levels.put(34, 4750000);
        levels.put(35, 6000000);
        levels.put(36, 7500000);
        levels.put(37, 9500000);
        levels.put(38, 12000000);
        levels.put(39, 15000000);
        levels.put(40, 20000000);

        for (Map.Entry<Integer, Integer> entry : levels.entrySet()) {
            if (xpToDate <= entry.getValue()) {
                userLevel = entry.getKey() - 1;
                System.out.println("Your current level is: " + userLevel);
                break;
            }
        }
        return userLevel;
    }

    public static long calculateDate(String startDate) {
        long durationInDays = 0;
        DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate localDate_1 = LocalDate.parse(startDate, formatter_1);
        LocalDate currentDate = LocalDate.now();

        if (!localDate_1.equals(currentDate)) {
            durationInDays = ChronoUnit.DAYS.between(localDate_1, currentDate);
            System.out.println("You have been playing for " + durationInDays + " days");
        }
        return durationInDays;
    }
}