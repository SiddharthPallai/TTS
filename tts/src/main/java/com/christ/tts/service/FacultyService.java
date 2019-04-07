/**
 * 
 */
package com.christ.tts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christ.tts.model.Course;
import com.christ.tts.model.Faculty;
import com.christ.tts.repository.CourseRepository;
import com.christ.tts.repository.FacultyRepository;

/**
 * @author spallai
 *
 */
@Service("facultyService")
public class FacultyService {
	
	FacultyRepository facultyRepository;
	
	@Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
	
    public List<Faculty> listAllFaculties() {
    	return facultyRepository.findAll();
    }
    
    public void deleteFaculty(int fid) {
    	facultyRepository.delete(facultyRepository.findById(fid));
    }
    
}
