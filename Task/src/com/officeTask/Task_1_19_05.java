package com.officeTask;

import java.util.*;

public class Task_1_19_05 
{

    public static void main(String[] args) 
    {

        // Map 1: Leave Balance
        Map<String, Map<String, Integer>> leaveBalance = new LinkedHashMap<>();
        leaveBalance.put("2025-05", Map.of("EL", 5, "SL", 2));
        leaveBalance.put("2025-06", Map.of("EL", 4, "SL", 1));

        // Map 2: PresentDays
        Map<String, Integer> PresentDays = new LinkedHashMap<>();
        PresentDays.put("2025-05", 20);
        PresentDays.put("2025-06", 24);

        // Map 3: Leaves Accepted
        Map<String, Map<String, Integer>> leaveAccepted = new LinkedHashMap<>();
        leaveAccepted.put("2025-05", Map.of("AccpetedEL", 2, "AccpetedSL", 1));
        leaveAccepted.put("2025-06", Map.of("AccpetedEL", 1, "AccpetedSL", 0));

        // Final Report
        System.out.println("=== Consolidated Working Day Summary ===\n");

        for (String yearMonth : leaveBalance.keySet()) 
        {
            if (PresentDays.containsKey(yearMonth) && leaveAccepted.containsKey(yearMonth)) 
            {
                int presentDays = PresentDays.get(yearMonth);
                int accpetedEL = leaveAccepted.get(yearMonth).getOrDefault("AccpetedEL", 0);
                int accpetedSL = leaveAccepted.get(yearMonth).getOrDefault("AccpetedSL", 0);

                int totalWorkingDays = presentDays + accpetedEL + accpetedSL;

                String[] split = yearMonth.split("-");
                String year = split[0];
                String month = getMonthName(split[1]);

                System.out.println(" Month: " + month + " " + year);
                System.out.println(" Total Working Days     : " + totalWorkingDays);
                System.out.println(" Present Working Days   : " + presentDays);
                System.out.println(" Accpeted EL            : " + accpetedEL);
                System.out.println(" Accepted SL            : " + accpetedSL);
                System.out.println("---------------------------------------------------\n");
            }
        }
    }

    private static String getMonthName(String monthNumber) 
    {
        int month = Integer.parseInt(monthNumber);
        return new java.text.DateFormatSymbols().getMonths()[month - 1];
    }
}
