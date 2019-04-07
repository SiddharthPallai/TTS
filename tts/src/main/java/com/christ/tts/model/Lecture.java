package com.christ.tts.model;
/**
 * 
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
@Table(name = "lecture")
public class Lecture {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lectureid")
    private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "lecture_period", joinColumns = @JoinColumn(name = "lectureid"), inverseJoinColumns = @JoinColumn(name = "periodid"))
	private Set<Period> periods;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "lecture_dayofweek", joinColumns = @JoinColumn(name = "lectureid"), inverseJoinColumns = @JoinColumn(name = "dayid"))
	private Set<DayOfWeek> days;
	
	@OneToOne(mappedBy = "lecture",fetch = FetchType.EAGER,cascade =  CascadeType.ALL)
	private Subject subject;	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "lecture_faculty", joinColumns = @JoinColumn(name = "lectureid"), inverseJoinColumns = @JoinColumn(name = "facultyid"))
	private Set<Faculty> faculties;
	
	@OneToOne(mappedBy = "lecture",fetch = FetchType.EAGER,cascade =  CascadeType.ALL)
	private Location location;
	
}
