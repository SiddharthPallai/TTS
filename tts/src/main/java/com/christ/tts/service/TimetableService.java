/**
 * 
 */
package com.christ.tts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christ.tts.model.Course;
import com.christ.tts.model.DayOfWeek;
import com.christ.tts.model.Period;
import com.christ.tts.repository.DayOfWeekRepository;
import com.christ.tts.repository.PeriodRepository;
import com.christ.tts.repository.TimetableRepository;

/**
 * @author spallai
 *
 */
@Service("ttService")
public class TimetableService {

	TimetableRepository ttRepository;
	DayOfWeekRepository dayRepo;
	PeriodRepository periodRepo;
	
	@Autowired
	public TimetableService(TimetableRepository ttRepository,DayOfWeekRepository dayRepo,PeriodRepository periodRepo) {
		this.ttRepository = ttRepository;
		this.dayRepo = dayRepo;
		this.periodRepo = periodRepo;
	}
	
	public List<Period> listPeriods(){
		return periodRepo.findAll();
	}
	
	public List<DayOfWeek> listDays(){
		return dayRepo.findAll();
	}
}
