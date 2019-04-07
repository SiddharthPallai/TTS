/**
 * 
 */
package com.christ.tts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.christ.tts.model.Course;
import com.christ.tts.model.Faculty;
import com.christ.tts.service.FacultyService;


/**
 * @author spallai
 *
 */
@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
Logger log = LogManager.getLogger(FacultyController.class);
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/listall", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Faculty f = new Faculty();
		modelAndView.addObject("f", f);
		modelAndView.addObject("faculties", facultyService.listAllFaculties());
		modelAndView.setViewName("admin/faculty");
		return modelAndView;
	}
	
	@RequestMapping("faculty/delete/{id}")
	public String delete(@PathVariable Integer fid) {
		facultyService.deleteFaculty(fid);
		return "redirect:/faculty/listall";
	}

}
