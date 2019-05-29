package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ScheduledTaskKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "task_instance")
	private String taskInstance;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskInstance() {
		return taskInstance;
	}

	public void setTaskInstance(String taskInstance) {
		this.taskInstance = taskInstance;
	}

}
