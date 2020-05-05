package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MODULE_BIDIRECTIONAL_12MANY")
public class Module {
	@Id
	@Column(name = "MODULE_ID")
	private int moduleId;
	
	@Column(name = "MODULE_NAME")
	private String moduleName;
	
	@Column(name = "MODULE_TYPE")
	private String moduleType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PID_FK")
	private Product prod;

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleType=" + moduleType + "]";
	}
	
}//class
