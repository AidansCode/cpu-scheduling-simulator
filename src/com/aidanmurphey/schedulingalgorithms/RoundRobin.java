package com.aidanmurphey.schedulingalgorithms;

import com.aidanmurphey.CPUBurst;
import com.aidanmurphey.Task;

import java.util.List;

public class RoundRobin implements CPUSchedulingAlgorithm {

	private int timeQuantum;
	private int currentTaskIndex;

	public RoundRobin(int timeQuantum) {
		this.timeQuantum = timeQuantum;
		this.currentTaskIndex = 0;
	}

	@Override
	public CPUBurst getNextBurst(List<Task> taskList) {
		if (taskList.isEmpty()) {
			return null;
		}

		Task nextTask = taskList.get(currentTaskIndex);
		int burstTimeRemaining = nextTask.getRequiredBurstTime() - nextTask.getBurstTimeProgress();
		int burstTime;
		if (timeQuantum < burstTimeRemaining) {
			//Task will require more burts than this to finish, set burst time to quantum time
			burstTime = timeQuantum;
			currentTaskIndex++;
		} else {
			//Task will be completed after this burst, remove it from the task list
			burstTime = burstTimeRemaining;
			taskList.remove(currentTaskIndex);
		}

		if (currentTaskIndex == taskList.size())
			//wrap over if necessary
			currentTaskIndex = 0;

		return new CPUBurst(nextTask, burstTime);
	}

}
