/**
 * 
 */
package com.christ.tts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.christ.tts.service.CourseService;
import com.christ.tts.service.TimetableService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author spallai
 *
 */
@RestController
@RequestMapping("/timetable")
public class TimetableController {
	
	Logger log = LogManager.getLogger(TimetableController.class);
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private TimetableService ttService;

	@GetMapping(value = "/new")
	public ModelAndView newTimetable() {
		log.info("create new timetable");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courses", courseService.listAllCourses());
		modelAndView.setViewName("admin/timetable");
		return modelAndView;
	}
	
	@RequestMapping("/timetable/show/{id}")
	public String show(@PathVariable Integer id) {
		log.debug("show timetable===================="+id);
		return "redirect:/course";
	}
	
	@GetMapping(value = "/renderTable")
	@ResponseBody
	public Response listPeriodDays() {
		System.out.println("render table");
		Response res = new Response("Done",ttService.listPeriods(),ttService.listDays());
		return res;
	}
	
	@GetMapping(value = "/addLecture")
	public ModelAndView addLecture() {
		System.out.println("addLecture");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courses", courseService.listAllCourses());
		modelAndView.setViewName("admin/lecture");
		return modelAndView;
	}
	
}
