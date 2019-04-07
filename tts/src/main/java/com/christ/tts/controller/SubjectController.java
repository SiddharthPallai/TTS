/**
 * 
 */
package com.christ.tts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.christ.tts.model.Course;
import com.christ.tts.model.Faculty;
import com.christ.tts.model.Subject;
import com.christ.tts.service.CourseService;
import com.christ.tts.service.FacultyService;
import com.christ.tts.service.SubjectService;

/**
 * @author spallai
 *
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

	Logger log = LogManager.getLogger(SubjectController.class);

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private CourseService courseService;

	@GetMapping(value = "/listSemsAndCourses")
	public ModelAndView listSemsAndCourses() {
		log.info("listing all sems and courses");
		ModelAndView modelAndView = new ModelAndView();
		Iterable courses = courseService.listAllCourses();
		System.out.println(courses);
		Subject sub = new Subject();

		modelAndView.addObject("courses", courses);
		modelAndView.addObject("subTypes", getSubjectTypes());

		modelAndView.addObject("sub", sub);
		modelAndView.setViewName("admin/subject");
		return modelAndView;
	}

	@ModelAttribute("subTypes")
	public Map<Integer, String> getSubjectTypes() {
		Map<Integer, String> subTypes = new HashMap<Integer, String>();
		subTypes.put(0, "Lab");
		subTypes.put(1, "Theory");
		return subTypes;
	}

	@RequestMapping(value = "/newSubject", method = RequestMethod.POST)
	public ModelAndView createNewSubject(@Valid Subject subject, BindingResult bindingResult) {
		System.out.println("22222----------------------2");

		ModelAndView modelAndView = new ModelAndView();
		if (subjectService.isAvailable(subject)) {
			bindingResult.rejectValue("name", "error.course", "There is already a course available");
		}
		subjectService.addSubject(subject);
//		courseService.addCourse(course);
		modelAndView.addObject("successMessage", "Course has been added successfully");
		modelAndView.addObject("subject", new Subject());
		//modelAndView.addObject("subjects", subjectService.listAllSubjects());
		modelAndView.setViewName("admin/subject");
		return modelAndView;
	}

}
