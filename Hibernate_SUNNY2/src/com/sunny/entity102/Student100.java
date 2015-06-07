package com.sunny.entity102;

// default package



/**
 * Student100 entity. @author MyEclipse Persistence Tools
 */

public class Student100  implements java.io.Serializable {


    // Fields    

     private Integer sno;
     private Class100 class100;
     private String name;


    // Constructors

    /** default constructor */
    public Student100() {
    }

	/** minimal constructor */
    public Student100(Integer sno) {
        this.sno = sno;
    }
    
    /** full constructor */
    public Student100(Integer sno, Class100 class100, String name) {
        this.sno = sno;
        this.class100 = class100;
        this.name = name;
    }

   
    // Property accessors

    public Integer getSno() {
        return this.sno;
    }
    
    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public Class100 getClass100() {
        return this.class100;
    }
    
    public void setClass100(Class100 class100) {
        this.class100 = class100;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Student100 [class100=" + class100 + ", name=" + name + ", sno="
				+ sno + "]";
	}
}