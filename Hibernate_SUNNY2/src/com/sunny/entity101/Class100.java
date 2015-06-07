package com.sunny.entity101;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Class100 entity. @author MyEclipse Persistence Tools
 */

public class Class100  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Set students = new HashSet();


    // Constructors

    /** default constructor */
    public Class100() {
    }

	/** minimal constructor */
    public Class100(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Class100(Integer id, String name, Set students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

	public Set getStudents() {
		return students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}



}