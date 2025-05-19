package com.officeTask;

import java.util.*;

public class Task_1_19_05 
{

    public static void main(String[] args) 
    {

        // Map 1: Leave Balance
        Map<String, Map<String, Integer>> leaveBalanceMap = new HashMap<>();
        leaveBalanceMap.put("2025-05", Map.of("EL", 5, "SL", 2));

        // Map 2: Attendance
        Map<String, Integer> attendanceMap = new HashMap<>();
        attendanceMap.put("2025-05", 20);

        // Map 3: Awarded Leaves
        Map<String, Map<String, Integer>> leaveAwardedMap = new HashMap<>();
        leaveAwardedMap.put("2025-05", Map.of("AwardedEL", 2, "AwardedSL", 1));

        // Final Report
        System.out.println("=== Consolidated Working Day Summary ===\n");

        for (String yearMonth : leaveBalanceMap.keySet()) 
        {
            if (attendanceMap.containsKey(yearMonth) && leaveAwardedMap.containsKey(yearMonth)) 
            {
                int presentDays = attendanceMap.get(yearMonth);
                int awardedEL = leaveAwardedMap.get(yearMonth).getOrDefault("AwardedEL", 0);
                int awardedSL = leaveAwardedMap.get(yearMonth).getOrDefault("AwardedSL", 0);

                int totalWorkingDays = presentDays + awardedEL + awardedSL;

                String[] split = yearMonth.split("-");
                String year = split[0];
                String month = getMonthName(split[1]);

                System.out.println(" Month: " + month + " " + year);
                System.out.println(" Total Working Days    : " + totalWorkingDays);
                System.out.println(" Present Working Days  : " + presentDays);
                System.out.println(" Awarded EL            : " + awardedEL);
                System.out.println(" Awarded SL            : " + awardedSL);
                System.out.println("———————————————\n");
            }
        }
    }

    private static String getMonthName(String monthNumber) 
    {
        int month = Integer.parseInt(monthNumber);
        return new java.text.DateFormatSymbols().getMonths()[month - 1];
    }
}
