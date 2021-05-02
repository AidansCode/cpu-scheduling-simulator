package com.aidanmurphey;

import com.aidanmurphey.schedulingalgorithms.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        runSimulation(new FirstComeFirstServe());
        runSimulation(new RoundRobin(2));
        runSimulation(new ShortestJobFirst());
        runSimulation(new PriorityQueue());
    }

    public static ArrayList<Task> getTaskList() {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1, 3, 3));
        taskList.add(new Task(2, 5, 4));
        taskList.add(new Task(3, 2, 3));
        taskList.add(new Task(4, 4, 2));
        taskList.add(new Task(5, 3, 1));
        taskList.add(new Task(6, 1, 10));

        return taskList;
    }

    public static void runSimulation(CPUSchedulingAlgorithm cpuSchedulingAlgorithm) {
        String name = cpuSchedulingAlgorithm.getClass().getSimpleName();
        System.out.println(name);
        for (int i = 0; i < name.length(); i++) {
            System.out.print('-');
        }
        System.out.print('\n');

        CPU cpu = new CPU(getTaskList(), cpuSchedulingAlgorithm);

        cpu.processTaskList();
        System.out.print('\n');
        cpu.outputStats();

        System.out.print('\n');
    }

}
