package com.officeTask;

import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.*;

public class Task_1_19_05 
{

    public static void main(String[] args)
    {
        // Map 1: Leave Balances
        Map<YearMonth, Map<String, Integer>> leaveBalanceMap = new HashMap<>();
        // Map 2: Present Days
        Map<YearMonth, Integer> presentDaysMap = new HashMap<>();
        // Map 3: Awarded Leaves
        Map<YearMonth, Map<String, Integer>> awardedLeaveMap = new HashMap<>();

        // Sample Data
        YearMonth jan = YearMonth.of(2024, 1);
        YearMonth feb = YearMonth.of(2024, 2);

        leaveBalanceMap.put(jan, Map.of("EL", 5, "SL", 2));
        leaveBalanceMap.put(feb, Map.of("EL", 4, "SL", 1));

        presentDaysMap.put(jan, 20);
        presentDaysMap.put(feb, 18);

        awardedLeaveMap.put(jan, Map.of("EL", 2, "SL", 1));
        awardedLeaveMap.put(feb, Map.of("EL", 1, "SL", 2));

        // Generate Final Report Map
        Map<YearMonth, Map<String, Integer>> finalReport = new TreeMap<>();

        for (YearMonth ym : presentDaysMap.keySet()) 
        {
            int present = presentDaysMap.getOrDefault(ym, 0);
            Map<String, Integer> awarded = awardedLeaveMap.getOrDefault(ym, Map.of("EL", 0, "SL", 0));
            int awardedEL = awarded.getOrDefault("EL", 0);
            int awardedSL = awarded.getOrDefault("SL", 0);
            int total = present + awardedEL + awardedSL;

            Map<String, Integer> data = new HashMap<>();
            data.put("TotalWorkingDays", total);
            data.put("PresentWorkingDays", present);

            finalReport.put(ym, data);
        }

        // Print Final Report
        System.out.println("📊 Consolidated Working Day Summary Report:");
        System.out.println("-----------------------------------------------------");

        for (Map.Entry<YearMonth, Map<String, Integer>> entry : finalReport.entrySet()) 
        {
            YearMonth ym = entry.getKey();
            String monthName = ym.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            int year = ym.getYear();
            Map<String, Integer> data = entry.getValue();

            System.out.printf("🗓️  %s %d\n", monthName, year);
            System.out.printf("   - Total Working Days     : %d\n", data.get("TotalWorkingDays"));
            System.out.printf("   - Present Working Days   : %d\n", data.get("PresentWorkingDays"));
            System.out.println("-----------------------------------------------------");
        }
    }
}
