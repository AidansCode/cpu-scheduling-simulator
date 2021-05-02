package com.aidanmurphey.schedulingalgorithms;

import com.aidanmurphey.CPUBurst;
import com.aidanmurphey.Task;

import java.util.List;

public class ShortestJobFirst implements CPUSchedulingAlgorithm {

	@Override
	public CPUBurst getNextBurst(List<Task> taskList) {
		if (taskList.isEmpty()) {
			return null;
		}

		Task shortestTask = null;
		for (Task task : taskList) {
			if (shortestTask == null || task.getRequiredBurstTime() < shortestTask.getRequiredBurstTime())
				shortestTask = task;
		}

		taskList.remove(shortestTask);
		return new CPUBurst(shortestTask, shortestTask.getRequiredBurstTime());
	}

}
