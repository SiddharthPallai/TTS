/**
 * 
 */
package com.christ.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christ.tts.model.Period;

/**
 * @author spallai
 *
 */
public interface PeriodRepository extends JpaRepository<Period,Long>{
	Period findById(int periodid);
}
