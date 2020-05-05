package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MODULE12MANY_TAB")
public class Module {
	@Id
	@Column(name = "MODULE_ID")
	private int moduleId;
	
	@Column(name = "MODULE_NAME")
	private String moduleName;
	
	@Column(name = "MODULE_TYPE")
	private String moduleType;

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

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleType=" + moduleType + "]";
	}
	
}//class
