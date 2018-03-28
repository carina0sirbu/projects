package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import gui.Logger;

public class SimulationManager implements Runnable {

	private int timeLimit;
	private int maxProcessingTime;
	private int minProcessingTime;
	private int numberOfServers;
	private int numberOfTasks;

	private List<Task> generatedTasks;
	private volatile List<Server> queues;

	public SimulationManager(int timeLimit, int minProcessingTime, int maxProcessingTime, int numberOfServers,
			int numberOfTasks) {

		this.timeLimit = timeLimit;
		this.maxProcessingTime = maxProcessingTime;
		this.minProcessingTime = minProcessingTime;
		this.numberOfServers = numberOfServers;
		this.numberOfTasks = numberOfTasks;
		
		queues = new ArrayList<Server>();

		for (int i = 0; i < numberOfServers; i++) {

			queues.add(new Server(i));
		}
	}

	private void generateNRandomTasks() {

		generatedTasks = new ArrayList<Task>();
		Random r = new Random();
		for (int i = 0; i < numberOfTasks; i++) {
			generatedTasks.add(new Task(r.nextInt(timeLimit),
					r.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime));
		}

		extracted(); // sorts them by the arrival time

	}

	@SuppressWarnings("unchecked")
	private void extracted() {
		Collections.sort(generatedTasks);
	}

	public List<Server> getServerList() {
		return queues;
	}

	@Override
	public void run() {

		this.generateNRandomTasks();

		for (Server s : queues) {

			(new Thread(s)).start();

		}

		int noOfTheTask = 0;
		int simulationTime = 0;
		while (timeLimit > 0) {
			while (!generatedTasks.isEmpty() && simulationTime == generatedTasks.get(0).getArrivalTime()) {

				noOfTheTask++;

				Logger.addInLog("Task " + noOfTheTask + " (" + generatedTasks.get(0) + ") was added to the queue "
						+ queues.indexOf(leastTasks()) + " at simulation time: " + simulationTime);

				this.leastTasks().addTask(generatedTasks.get(0));
				generatedTasks.remove(0);
			}

			timeLimit--;
			simulationTime++;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (Server s : queues) {
			s.setActiveSimulation(false);
		}
		Logger.addInFile("file.txt");
	} // queues.get(i).addTask(generatedTasks.get(0));

	public Server leastTasks() {

		Server minServer = this.queues.get(0);

		for (int i = 1; i < numberOfServers; i++) {
			if (minServer.getQueue().size() > this.queues.get(i).getQueue().size()) {
				minServer = this.queues.get(i);
			}
		}
		return minServer;
	}

	public List<Task> getGeneratedTasks() {
		return generatedTasks;
	}

	public void setGeneratedTasks(List<Task> generatedTasks) {
		this.generatedTasks = generatedTasks;
	}

	public List<Server> getQueues() {
		return queues;
	}

	public void setQueues(List<Server> queues) {
		this.queues = queues;
	}

}
