/**
 * 
 */
package com.christ.tts.model;

import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.christ.tts.constants.Constants;

/**
 * @author spallai
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "period")
public class Period {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "periodid")
	private int id;
	@Column(name = "startime")
	@DateTimeFormat(pattern = "HH:mm")
	private Time starttime;
	@Column(name = "endtime")
	@DateTimeFormat(pattern = "HH:mm")
	private Time endtime;
	private String formattedTimeRange;
	
	public String getformattedTimeRange() {
		return Constants.PERIOD.get(id);		
	}
//	
//	public void setId(int id) {
//		this.id = id;
//		this.formattedTimeRange = Constants.PERIOD.get(id);	
//	}
}
