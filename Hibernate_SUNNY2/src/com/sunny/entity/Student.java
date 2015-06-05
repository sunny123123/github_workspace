package com.sunny.entity;

public class Student {
private int sno;
private String name;
private String address;
/**
 * 对应数据量的student表
 */
public Student() {
}
public Student(int sno, String name, String address) {
	this.sno = sno;
	this.name = name;
	this.address = address;
}

@Override
public String toString() {
	return "Student [address=" + address + ", name=" + name + ", sno=" + sno
			+ "]";
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
