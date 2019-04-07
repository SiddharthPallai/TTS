/**
 * 
 */
package com.christ.tts.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author spallai
 *
 */
public interface Constants {

	public static final int LAB = 0;
	public static final int THEORY = 1;
	public static final int ACTIVE_SEMESTER=1;
	public static final Map<String, Integer> DAY = new HashMap<String, Integer>() {
		{
			put("Mon", 1);
			put("Tue", 2);
			put("Wed", 3);
			put("Thu", 4);
			put("Fri", 5);
			put("Sat", 6);
			put("Sun", 7);
		}
	};
	public static final Map<Integer,String> PERIOD = new HashMap<Integer,String>() {
		{
			put(1,"09am-10am");
			put(2,"10am-11am");
			put(3,"11am-12am");
			put(4,"12am-01pm");
			put(5,"02pm-03pm");
			put(6,"03pm-04pm");			
		}
	};
}
