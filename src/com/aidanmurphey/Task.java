package com.aidanmurphey;

public class Task {

	private int id, requiredBurstTime, priority, burstTimeProgress, waitingTime, responseTime, turnaroundTime;

	public Task(int id, int requiredBurstTime, int priority) {
		setId(id);
		setRequiredBurstTime(requiredBurstTime);
		setPriority(priority);
		setBurstTimeProgress(0);
		setWaitingTime(0);
		setResponseTime(-1);
		setTurnaroundTime(-1);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getRequiredBurstTime() {
		return requiredBurstTime;
	}

	public void setRequiredBurstTime(int requiredBurstTime) {
		this.requiredBurstTime = requiredBurstTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getBurstTimeProgress() {
		return burstTimeProgress;
	}

	public void setBurstTimeProgress(int burstTimeProgress) {
		this.burstTimeProgress = burstTimeProgress;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}

	public int getTurnaroundTime() {
		return turnaroundTime;
	}

	public void setTurnaroundTime(int turnaroundTime) {
		this.turnaroundTime = turnaroundTime;
	}
}
