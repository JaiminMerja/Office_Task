package com.officeTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Task_1_19_05 
{
	public static void main(String[] args) 
	{
		//EL Balance 
		Map<String, Integer> ELBalance = new HashMap<>();
		ELBalance.put("2025-January", 20);
		ELBalance.put("2025-Feburary", 25);
		
		//SL Balance
		Map<String, Integer> SLBalance = new HashMap<>();
		SLBalance.put("2025-January", 7);
		SLBalance.put("2025-Feburary", 8);
		
		//Present Days
		Map<String, Integer> PDM = new HashMap<>();
		PDM.put("2025-January", 4);
		PDM.put("2025-Feburary", 5);
		
		//Award EL
		Map<String, Integer> AEL = new HashMap<>();
		AEL.put("2025-January", 7);
		AEL.put("2025-Feburary", 6);
		
		//Award SL
		Map<String, Integer> ASL = new HashMap<>();
		ASL.put("2025-January", 4);
		ASL.put("2025-Feburary", 3);
		
		//Merge Key
		Set<String> AllKey = new HashSet<>();
		AllKey.addAll(ELBalance.keySet());
		AllKey.addAll(SLBalance.keySet());
		AllKey.addAll(PDM.keySet());
		AllKey.addAll(AEL.keySet());
		AllKey.addAll(ASL.keySet());
		
		//Final Report
		Map<String, String> finalreport = new HashMap<>();
		{
			for(String key : AllKey)
			{
				int elBalance = ELBalance.getOrDefault(key, 0);
				int slBalance = SLBalance.getOrDefault(key, 0);
				int presentday = PDM.getOrDefault(key, 0);
				int elAward = AEL.getOrDefault(key, 0);
				int slAward = ASL.getOrDefault(key, 0);
				
				int totalworkingday = presentday + elAward + slAward;
				
				String report = "Total Working Days:" + totalworkingday + ", Present Days:" + presentday;
				finalreport.put(key, report);
			}
			System.out.println("Final Report of Working Days......");
			for(Map.Entry<String, String> entry : finalreport.entrySet())
			{
				System.out.println(entry.getKey() +" -> "+ entry.getValue());
			}
		}
	}
}
