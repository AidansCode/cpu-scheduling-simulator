package com.aidanmurphey.schedulingalgorithms;

import com.aidanmurphey.CPUBurst;
import com.aidanmurphey.Task;

import java.util.List;

public interface CPUSchedulingAlgorithm {

	public CPUBurst getNextBurst(List<Task> taskList);

}
