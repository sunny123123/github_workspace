package com.sunny.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clazz entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "class100", catalog = "test100")
public class Clazz implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Clazz() {
	}

	/** full constructor */
	public Clazz(String name, Set<Student> students) {
		this.name = name;
		this.students = students;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clazz")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}