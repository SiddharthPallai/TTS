/**
 * 
 */
package com.christ.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christ.tts.model.Timetable;


/**
 * @author spallai
 *
 */
public interface TimetableRepository extends JpaRepository<Timetable,Long>{
	Timetable findById(int ttid);
}
