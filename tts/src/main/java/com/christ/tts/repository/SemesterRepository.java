/**
 * 
 */
package com.christ.tts.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christ.tts.model.Course;
import com.christ.tts.model.Semester;

/**
 * @author spallai
 *
 */
@Repository("semesterRepository")
public interface SemesterRepository  extends JpaRepository<Semester,Long>{
	 Set<Semester> findSemesterByActive(int active);
}
