package com.sunny.entity200;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Student200 entity. @author MyEclipse Persistence Tools
 */

public class Student200  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Set<Course200> courses = new HashSet<Course200>();


    // Constructors

    /** default constructor */
    public Student200() {
    }

    
    /** full constructor */
    public Student200(String name, Set courses) {
        this.name = name;
        this.courses = courses;
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


	public Set<Course200> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course200> courses) {
		this.courses = courses;
	}

   
}