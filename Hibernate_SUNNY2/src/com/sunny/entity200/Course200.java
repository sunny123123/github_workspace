package com.sunny.entity200;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Course200 entity. @author MyEclipse Persistence Tools
 */

public class Course200  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Set<Student200> students = new HashSet<Student200>();

    // Constructors

    /** default constructor */
    public Course200() {
    }

    
    /** full constructor */
    public Course200(String name) {
        this.name = name;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


	public Set<Student200> getStudents() {
		return students;
	}


	public void setStudents(Set<Student200> students) {
		this.students = students;
	}



}