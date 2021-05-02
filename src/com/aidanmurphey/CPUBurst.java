package com.aidanmurphey;

public class CPUBurst {

	private Task task;
	private int burstTime;

	public CPUBurst(Task task, int burstTime) {
		this.task = task;
		this.burstTime = burstTime;
	}

	public Task getTask() {
		return task;
	}

	public int getBurstTime() {
		return burstTime;
	}
}
