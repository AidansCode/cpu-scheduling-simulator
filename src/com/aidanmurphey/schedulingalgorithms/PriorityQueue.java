package com.aidanmurphey.schedulingalgorithms;

import com.aidanmurphey.CPUBurst;
import com.aidanmurphey.Task;

import java.util.List;

public class PriorityQueue implements CPUSchedulingAlgorithm {

	@Override
	public CPUBurst getNextBurst(List<Task> taskList) {
		if (taskList.isEmpty()) {
			return null;
		}

		Task highestPriorityTask = null;
		for (Task task : taskList) {
			if (highestPriorityTask == null || task.getPriority() < highestPriorityTask.getPriority())
				highestPriorityTask = task;
		}

		taskList.remove(highestPriorityTask);

		return new CPUBurst(highestPriorityTask, highestPriorityTask.getRequiredBurstTime());
	}

}
