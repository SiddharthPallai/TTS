/**
 * 
 */
package com.christ.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christ.tts.model.Faculty;

/**
 * @author spallai
 *
 */
public interface FacultyRepository extends JpaRepository<Faculty,Long>{
	Faculty findById(int id);	
}