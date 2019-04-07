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
@Table(name = "department")
public class Department {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deptid")
    private int id;
	
	@Column(name = "name")
    @NotEmpty(message = "*Please provide department name")
	private String name;
	
}
