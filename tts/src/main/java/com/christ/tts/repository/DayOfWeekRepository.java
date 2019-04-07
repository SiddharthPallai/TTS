/**
 * 
 */
package com.christ.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christ.tts.model.Course;
import com.christ.tts.model.DayOfWeek;
import com.christ.tts.model.Timetable;

/**
 * @author spallai
 *
 */
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek,Long>{
	DayOfWeek findById(int courseid);
	DayOfWeek findByDayName(String name);

}
