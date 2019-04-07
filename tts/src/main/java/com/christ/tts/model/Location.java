/**
 * 
 */
package com.christ.tts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author spallai
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "locationid")
    private int id;	
	@Column(name = "name")
    @NotEmpty(message = "*Please provide room name")
	private String name;
	@Column(name = "blockname")
    @NotEmpty(message = "*Please provide block name")
	private String blockName;
	@Column(name = "roomtype")
    @NotEmpty(message = "*Please provide type of classroom (LAB/Theory)")
	private int roomType;
	@Column(name = "capacity")
    @NotEmpty(message = "*Please provide capacity of the classroom")
	private int capacity;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semester_id", nullable = false)
	private Semester semester;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lecture_id", nullable = false)
	private Lecture lecture;
}
