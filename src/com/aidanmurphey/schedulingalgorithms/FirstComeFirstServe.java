package com.aidanmurphey.schedulingalgorithms;

import com.aidanmurphey.CPUBurst;
import com.aidanmurphey.Task;

import java.util.List;

public class FirstComeFirstServe implements CPUSchedulingAlgorithm {

	@Override
	public CPUBurst getNextBurst(List<Task> taskList) {
		if (taskList.isEmpty()) {
			return null;
		}

		Task task = taskList.get(0);
		taskList.remove(task);
		return new CPUBurst(task, task.getRequiredBurstTime());
	}

}
