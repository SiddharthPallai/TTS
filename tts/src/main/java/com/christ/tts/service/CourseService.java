/**
 * 
 */
package com.christ.tts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christ.tts.model.Course;
import com.christ.tts.model.Faculty;
import com.christ.tts.model.Semester;
import com.christ.tts.model.Subject;
import com.christ.tts.repository.CourseRepository;
import com.christ.tts.repository.FacultyRepository;
import com.christ.tts.repository.SemesterRepository;
import com.christ.tts.repository.SubjectRepository;


/**
 * @author spallai
 *
 */
@Service("courseService")
public class CourseService {

	CourseRepository courseRepository;
	SemesterRepository semesterRepository;
	FacultyRepository facultyRepository;
	SubjectRepository subjectRepository;
		
	@Autowired
    public CourseService(CourseRepository courseRepository,SemesterRepository semesterRepository, FacultyRepository facultyRepository, SubjectRepository subjectRepository) {
        this.courseRepository = courseRepository;
        this.semesterRepository = semesterRepository;
        this.facultyRepository = facultyRepository;
        this.subjectRepository = subjectRepository;
    }
	
    public Iterable<Course> listAllCourses() {
    	return courseRepository.findAll();
    }
    
    public List<Faculty> listAllFaculty() {
    	return facultyRepository.findAll();
    }
    
    public void deleteCourse(int courseid) {
        courseRepository.delete(courseRepository.findById(courseid));
    }
	
    public Course findCourseById(int courseid) {
        return courseRepository.findById(courseid);
    }
    
    public Faculty findFacultyById(int facultyId) {
        return facultyRepository.findById(facultyId);
    }
    
    public Set<Semester> findSemesterByActive(int active) {
        return semesterRepository.findSemesterByActive(active);
    }
    
    public Course addCourse(Course course) {
    	List<Semester> setOfSemesters = new ArrayList<Semester>();
    	for(int i=1;i<=course.getSemcount();i++) {
    		Semester sem = new Semester();
    		sem.setActive(0);
    		sem.setSemnum(i);
    		setOfSemesters.add(sem);
    	}
    	course.setSemesters(setOfSemesters);
    	return courseRepository.save(course);
    }
    
    public boolean isAvailable(Course course) {    	
    	return (courseRepository.findByName(course.getName())==null)?false:true;
    }
    
    public Subject addSubject(Subject sub) {
    	System.out.println(sub);
    	return subjectRepository.save(sub);
    }
    
    public Faculty addSubjectToFaculty(Faculty f) {
    	System.out.println(f);
    	return facultyRepository.save(f);
    }
    
}
