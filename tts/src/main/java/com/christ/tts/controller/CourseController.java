/**
 * 
 */
package com.christ.tts.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.christ.tts.model.Course;
import com.christ.tts.model.Faculty;
import com.christ.tts.model.Semester;
import com.christ.tts.model.Subject;
import com.christ.tts.service.CourseService;

/**
 * @author spallai
 *
 */
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Course course = new Course();
		modelAndView.addObject("course", course);
		modelAndView.addObject("courses", courseService.listAllCourses());
		modelAndView.setViewName("admin/course");
		return modelAndView;
	}

	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@Valid Course course, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (courseService.isAvailable(course)) {
			bindingResult.rejectValue("name", "error.course", "There is already a course available");
		}
//		if (bindingResult.hasErrors()) {
//			modelAndView.setViewName("admin/course");
//			modelAndView.addObject("courses", courseService.listAllCourses());
//		} else {
			courseService.addCourse(course);
			modelAndView.addObject("successMessage", "Course has been added successfully");
			modelAndView.addObject("course", new Course());
			modelAndView.addObject("courses", courseService.listAllCourses());
			modelAndView.setViewName("admin/course");

//		}
		return modelAndView;
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public ModelAndView schedule() {
		System.out.println("33333333");
		ModelAndView modelAndView = new ModelAndView();
		Course course = new Course();
		modelAndView.addObject("course", course);
		modelAndView.addObject("courses", courseService.listAllCourses());
		modelAndView.setViewName("admin/schedule");
		return modelAndView;
	}

	@RequestMapping("course/delete/{id}")
	public String delete(@PathVariable Integer id) {
		courseService.deleteCourse(id);
		return "redirect:/course";
	}

	@RequestMapping(value = "/course/subject", method = RequestMethod.GET, params = {"courseid"})
	public ModelAndView subjects(@RequestParam(value="courseid") int courseid) {
	
		ModelAndView modelAndView = new ModelAndView();
		Course crs = courseService.findCourseById(courseid);
		Subject subject = new Subject();
		modelAndView.addObject("subject",subject);
		modelAndView.addObject("courseName",crs.getName());
		List<Semester> sems = crs.getSemesters();Collections.sort(sems);
		modelAndView.addObject("semesters", sems);
		List<Faculty> facs = courseService.listAllFaculty();
		modelAndView.addObject("facs", facs);
		modelAndView.setViewName("admin/subject");
		return modelAndView;
	}
	
	@RequestMapping(value = "/course/subject/add", method = RequestMethod.POST)
	public ModelAndView addSubjects(@Valid Subject subject, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Faculty f = null;//courseService.findFacultyById(subject.getFacId());
		List<Subject> l = new ArrayList<Subject>();
		l.add(subject);
		f.setSubjects(l);
		modelAndView.addObject("sub",courseService.addSubjectToFaculty(f));
		
		modelAndView.setViewName("admin/subject");
		
		
		
		
//		if (courseService.isAvailable(course)) {
//			bindingResult.rejectValue("name", "error.course", "There is already a course available");
//		}
//		if (bindingResult.hasErrors()) {
//			modelAndView.addObject("course", new Course());
//			modelAndView.setViewName("admin/course");
//		} else {
		
		
		
		
//			courseService.addCourse(course);
//			modelAndView.addObject("successMessage", "Course has been added successfully");
//			modelAndView.addObject("course", new Course());
//			modelAndView.addObject("courses", courseService.listAllCourses());
//			modelAndView.setViewName("admin/course");
//
//		}
		return modelAndView;
	}

}
