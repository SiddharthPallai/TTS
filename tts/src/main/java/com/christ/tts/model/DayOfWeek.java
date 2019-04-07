/**
 * 
 */
package com.christ.tts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @author spallai
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dayofweek")
public class DayOfWeek {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dayid")
	private int id;
	@Column(name = "dayname")
	private String dayName;
}
