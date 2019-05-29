package com.example.demo.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name="scheduled_tasks")
public class ScheduledTask {
	@Id
	private ScheduledTaskKey scheduledTaskKey;

	@Column(name = "task_data")
	private byte[] taskData;

	@Column(name = "execution_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date executionTime;

	@Column(name = "picked")
	private Boolean picked;

	@Column(name = "picked_by")
	private char[] pickedBy;

	@Column(name = "last_success")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastSuccess;

	@Column(name = "last_failure")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastFailure;

	@Column(name = "consecutive_failures")
	private Integer consecutiveFailures;

	@Column(name = "last_heartbeat")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastHeartbeat;

	@Version
	private long version;

	public ScheduledTaskKey getScheduledTaskKey() {
		return scheduledTaskKey;
	}

	public void setScheduledTaskKey(ScheduledTaskKey scheduledTaskKey) {
		this.scheduledTaskKey = scheduledTaskKey;
	}

	public byte[] getTaskData() {
		return taskData;
	}

	public void setTaskData(byte[] taskData) {
		this.taskData = taskData;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public Boolean getPicked() {
		return picked;
	}

	public void setPicked(Boolean picked) {
		this.picked = picked;
	}

	public char[] getPickedBy() {
		return pickedBy;
	}

	public void setPickedBy(char[] pickedBy) {
		this.pickedBy = pickedBy;
	}

	public Date getLastSuccess() {
		return lastSuccess;
	}

	public void setLastSuccess(Date lastSuccess) {
		this.lastSuccess = lastSuccess;
	}

	public Date getLastFailure() {
		return lastFailure;
	}

	public void setLastFailure(Date lastFailure) {
		this.lastFailure = lastFailure;
	}

	public Integer getConsecutiveFailures() {
		return consecutiveFailures;
	}

	public void setConsecutiveFailures(Integer consecutiveFailures) {
		this.consecutiveFailures = consecutiveFailures;
	}

	public Date getLastHeartbeat() {
		return lastHeartbeat;
	}

	public void setLastHeartbeat(Date lastHeartbeat) {
		this.lastHeartbeat = lastHeartbeat;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
