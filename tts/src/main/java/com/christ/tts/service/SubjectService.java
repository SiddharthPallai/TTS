/**
 * 
 */
package com.christ.tts.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christ.tts.model.Course;
import com.christ.tts.model.Semester;
import com.christ.tts.model.Subject;
import com.christ.tts.repository.SubjectRepository;

/**
 * @author spallai
 *
 */
@Service("subjectService")
public class SubjectService {
	
		SubjectRepository subjectRepository;
		
		@Autowired
	    public SubjectService(SubjectRepository subjectRepository) {
	        this.subjectRepository = subjectRepository;
	    }
		
	    public boolean isAvailable(Subject subject) {    	
	    	return (subjectRepository.findByName(subject.getName())==null)?false:true;
	    }
	    
	    public Subject addSubject(Subject subject) {
	    	List<Semester> setOfSemesters = new ArrayList<Semester>();
//	    	for(int i=1;i<=course.getSemcount();i++) {
//	    		Semester sem = new Semester();
//	    		sem.setActive(0);
//	    		sem.setSemnum(i);
//	    		setOfSemesters.add(sem);
//	    	}
//	    	course.setSemesters(setOfSemesters);
	    	return subjectRepository.save(subject);
	    }
		
//	    public List<Faculty> listAllSubjectsBySemester(int semid) {
//	    	return facultyRepository.findAll();
//	    }
//	    
//	    public void deleteFaculty(int fid) {
//	    	facultyRepository.delete(facultyRepository.findById(fid));
//	    }
	    
	}
