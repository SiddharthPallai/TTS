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
import javax.validation.constraints.NotNull;

/**
 * @author spallai
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subjectid")
    private int id;
	
	@Column(name = "name")
    @NotEmpty(message = "*Please provide subject name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "type")
	@NotNull(message = "*Please select subject type (LAB/Theory)")
	private Integer type;
	
	@Column(name = "shortname")
    @NotEmpty(message = "*Please provide shortname")
	private String shortName;
	
	@Column(name = "semesterid")
	private Integer semesterId;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "subjectid", nullable = false)
	private Lecture lecture;
}
