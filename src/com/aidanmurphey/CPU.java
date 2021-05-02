package com.aidanmurphey;

import com.aidanmurphey.schedulingalgorithms.CPUSchedulingAlgorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CPU {

	private List<Task> originalTaskList, remainingTasks;
	private CPUSchedulingAlgorithm cpuSchedlingAlgorithm;
	private int finishingTime;

	public CPU(List<Task> taskList, CPUSchedulingAlgorithm cpuSchedlingAlgorithm) {
		this.originalTaskList = taskList;
		this.remainingTasks = new ArrayList<>(taskList);
		this.cpuSchedlingAlgorithm = cpuSchedlingAlgorithm;
		this.finishingTime = -1;
	}

	public void processTaskList() {
		int time = 0;
		while (remainingTasks.size() > 0) {
			CPUBurst cpuBurst = cpuSchedlingAlgorithm.getNextBurst(remainingTasks);
			Task task = cpuBurst.getTask();
			System.out.println("At time " + time + ", task " + task.getId() + " runs for duration " + cpuBurst.getBurstTime());

			task.setWaitingTime(time - task.getBurstTimeProgress());
			task.setBurstTimeProgress(cpuBurst.getBurstTime() + task.getBurstTimeProgress());

			if (task.getResponseTime() == -1)
				task.setResponseTime(time);

			if (task.getBurstTimeProgress() == task.getRequiredBurstTime())
				task.setTurnaroundTime(time + cpuBurst.getBurstTime());

			time += cpuBurst.getBurstTime();
		}

		this.finishingTime = time;
	}

	public void outputStats() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		double averageWaitTime = originalTaskList.stream().mapToInt(task -> task.getWaitingTime()).average().getAsDouble();
		System.out.println("Average Wait Time: " + decimalFormat.format(averageWaitTime));

		double averageResponseTime = originalTaskList.stream().mapToInt(task -> task.getResponseTime()).average().getAsDouble();
		System.out.println("Average Response Time: " + decimalFormat.format(averageResponseTime));

		double averageTurnaroundTime = originalTaskList.stream().mapToInt(task -> task.getTurnaroundTime()).average().getAsDouble();
		System.out.println("Average Turnaround Time: " + decimalFormat.format(averageTurnaroundTime));

		System.out.println("Overall CPU Usage: " + this.finishingTime);
	}
}
