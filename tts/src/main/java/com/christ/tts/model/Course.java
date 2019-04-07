/**
 * 
 */
package com.christ.tts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

/**
 * @author spallai
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseid")
    private int id;
	
	@Column(name = "name")
    @NotEmpty(message = "*Please provide course name")
	private String name;
    
	@Max(8)
	@Column(name = "semcount")
	@NotNull(message = "*Please provide total semester")
	private Integer semcount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_semester", joinColumns = @JoinColumn(name = "courseid"), inverseJoinColumns = @JoinColumn(name = "semesterid"))
	private List<Semester> semesters;
	
}