package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_LIST_TAB")
public class Student {
	
	@Id
	@Column(name = "SID")
	private int stdId;
	
	@Column(name = "SNAME")
	private String stdName;
	
	@ElementCollection
	@CollectionTable(name = "STDPROJ_LIST_TAB",joinColumns = @JoinColumn(name="SID"))
	@OrderColumn(name = "PNO")
	@Column(name = "DATA")
	private List<String> stdProjData=new ArrayList<String>();
	
	public Student() {
		super();
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public List<String> getStdProjData() {
		return stdProjData;
	}

	public void setStdProjData(List<String> stdProjData) {
		this.stdProjData = stdProjData;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdProjData=" + stdProjData + "]";
	}
	
}//class
