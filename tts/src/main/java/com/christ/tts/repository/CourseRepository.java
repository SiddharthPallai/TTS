/**
 * 
 */
package com.christ.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.christ.tts.model.Course;

/**
 * @author spallai
 *
 */
public interface CourseRepository extends JpaRepository<Course,Long>{
	 Course findById(int courseid);
	 Course findByName(String name);
}
