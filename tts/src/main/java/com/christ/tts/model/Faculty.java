package com.christ.tts.model;
/**
 * 
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
@Table(name = "faculty")
public class Faculty {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "facultyid")
    private int id;	
	
	@Column(name = "title")
    private String title;	
	
	@Column(name = "firstname")
    @NotEmpty(message = "*Please provide first name")
	private String firstName;
	
	@Column(name = "lastname")
    @NotEmpty(message = "*Please provide last name")
	private String lastName;	
    
	@Column(name = "initials")
    private String initials;
    
	@Column(name = "email")
    @NotEmpty(message = "*Please provide email")
	private String email;
    
	@Column(name = "phone")
    @NotEmpty(message = "*Please provide contact number")
    private int phone;
    
	@Column(name = "hrsperweek")
    private int hoursPerWeek;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "faculty_subject", joinColumns = @JoinColumn(name = "facultyid"), inverseJoinColumns = @JoinColumn(name = "subjectid"))
	private List<Subject> subjects;
	
}
