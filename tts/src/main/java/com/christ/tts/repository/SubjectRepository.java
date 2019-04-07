/**
 * 
 */
package com.christ.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christ.tts.model.Course;
import com.christ.tts.model.Subject;

/**
 * @author spallai
 *
 */
@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<Subject,Long>{
	Subject findByName(String name);
	Subject findBySemesterId(String name);
}

