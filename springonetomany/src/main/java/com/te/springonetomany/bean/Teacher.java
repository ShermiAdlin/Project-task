 package com.te.springonetomany.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer teachId;
	private String teachName;
	
	@OneToMany(cascade = CascadeType.ALL)//if we change in one table that should change in other table also
	@JoinColumn(name = "std", referencedColumnName = "teachId")
	private List<Student> student;

}
