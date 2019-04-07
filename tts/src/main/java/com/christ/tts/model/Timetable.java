/**
 * 
 */
package com.christ.tts.model;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author spallai
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timetable")
public class Timetable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "timetableid")
	private int id;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semester_id", nullable = false)
	private Semester semester;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "timetable_lecture", joinColumns = @JoinColumn(name = "timetableid"), inverseJoinColumns = @JoinColumn(name = "lectureid"))
	private Set<Lecture> lectures;
}
