package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gui.Logger;

public class Server implements Runnable {

	private volatile List<Task> queue;
	private int queueNo;

	public Server(int queueNo) {

		this.queue = new ArrayList<Task>();
		this.queueNo = queueNo;

	}

	public Task peek() {
		return this.queue.get(0);
	}

	public void remove() {
		this.queue.remove(0);
	}

	public void addTask(Task t) {
		queue.add(t);
	}

	public int getNumberOfTasks() {
		return queue.size();
	}

	boolean activeSimulation = true;

	@Override
	public void run() {

		while (activeSimulation || !queue.isEmpty()) {

			if (!queue.isEmpty()) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.peek().decrProcTime();
				;

				// compares the procTime of the head of the queue with 0
				if (this.peek().getProcessingTime() == 0) {
					
					Logger.addInLog("Another task was removed from queue! ");

					this.remove();
					// removes the head of the queue
				}
			}
		}

	}

	public List<Task> getQueue() {
		return queue;
	}

	public void setQueue(List<Task> tasks) {
		this.queue = tasks;
	}

	public void setActiveSimulation(boolean activeSimulation) {
		this.activeSimulation = activeSimulation;
	}

}
