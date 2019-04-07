/**
 * 
 */
package com.christ.tts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "semester")
public class Semester implements Comparable<Semester>{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "semesterid")
	private int id;
	@Column(name = "semnum")
	private int semnum;
	@Column(name = "active")
	private int active;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "semester_lecture", joinColumns = @JoinColumn(name = "semesterid"), inverseJoinColumns = @JoinColumn(name = "lectureid"))
	private List<Lecture> lectures;
	
/*	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "semester")
    private Set<Subject> subjects = new HashSet<>();
	
	@OneToMany(targetEntity=Subject.class, mappedBy="semOfSubject",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Subject> subjects;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "semester_subject", joinColumns = @JoinColumn(name = "semesterid"), inverseJoinColumns = @JoinColumn(name = "subjectid"))
	private List<Subject> subjects;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "semester_subject", joinColumns = @JoinColumn(name = "semesterid"), inverseJoinColumns = @JoinColumn(name = "subjectid"))
	private List<Subject> subjects;
*/	
	@OneToOne(mappedBy = "semester",fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
	private Location location;
	
	@OneToOne(mappedBy = "semester",fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
	private Timetable timetable;
	
	/*
     * Sorting on orderId is natural sorting for Order.
     */
    @Override
    public int compareTo(Semester o) {
        return this.semnum > o.semnum ? 1 : (this.semnum < o.semnum ? -1 : 0);
    }

}
