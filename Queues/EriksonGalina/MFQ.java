import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Class that manages the queue input
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - March 23, 2014
 */

public class MFQ {

	private Scanner inputFile;
	private PrintWriter pw;
	private ObjectQueue queueOfJobs;
	private ObjectQueue queue1;
	private ObjectQueue queue2;
	private ObjectQueue queue3;
	private ObjectQueue queue4;
	
	private double total_number_of_jobs;
	private int total_time_of_all_jobs_in_system;
	private int average_response_time;
	//private int average_turnaround_time;
	private int waiting_time;
	private int cpu_idle;
	
	public MFQ(Scanner input, PrintWriter pw) {
		this.inputFile = input;
		this.pw = pw;
		this.queueOfJobs = new ObjectQueue();
		this.queue1 = new ObjectQueue();
		this.queue2 = new ObjectQueue();
		this.queue3 = new ObjectQueue();
		this.queue4 = new ObjectQueue();
		this.total_number_of_jobs = 0;
		this.total_time_of_all_jobs_in_system = 0;
		this.average_response_time = 0;
		//this.average_turnaround_time = 0;
		this.waiting_time = 0;
		this.cpu_idle = 0;
	}

	/**
	 * Method that extracts the job from 
	 */
	public void getJobs() {
		while (inputFile.hasNext()) {
			String buf = inputFile.nextLine();
			String[] tokens = buf.split("\\s+");
			Job temp = new Job(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
			queueOfJobs.insert(temp);
		}
	}
	
	/**
	 * Outputs the header
	 */
	public void outputHeader() {
		System.out.println("Event\tSystem Time\tPID\tCPUTimeNeeded\tTotalTimeInSystem\tLowestLevelQueue");
		pw.write("Event\tSystem Time\tPID\tCPUTimeNeeded\tTotalTimeInSystem\tLovestLevelQueue\n");
	}
	
	/**
	 * Calculates the statistics
	 */
	public void outStats() {
		System.out.println("\n#######STATISTICS#########");
		System.out.println("Total number of jobs: " + String.valueOf(total_number_of_jobs));
		System.out.println("Total time of all jobs in the system: " + String.valueOf(total_time_of_all_jobs_in_system));
		System.out.println("Average response time: " + String.valueOf(average_response_time));
		double turnaround =  total_time_of_all_jobs_in_system/total_number_of_jobs;
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.println("Average turnaround time for all jobs: " + df.format(turnaround));
		double wait_time = waiting_time/total_number_of_jobs;
		System.out.println("Average waiting time: " + df.format(wait_time));
		double throughput = total_number_of_jobs/total_time_of_all_jobs_in_system;
		System.out.println("Average throughput for the system as a whole: " + df.format(throughput));
		System.out.println("Total CPU idle time: " + String.valueOf(cpu_idle));
		
		pw.write("\n#######STATISTICS#########\n");
		pw.write("Total number of jobs: " + String.valueOf(total_number_of_jobs) + "\n");
		pw.write("Total time of all jobs in the system: " + String.valueOf(total_time_of_all_jobs_in_system) + "\n");
		pw.write("Average response time: " + String.valueOf(average_response_time) + "\n");
		pw.write("Average turnaround time for all jobs: " + df.format(turnaround) + "\n");
		pw.write("Average waiting time: " + df.format(wait_time) + "\n");
		pw.write("Average throughput for the system as a whole: " + df.format(throughput) + "\n");
		pw.write("Total CPU idle time: " + String.valueOf(cpu_idle) + "\n");
	}
	
	/**
	 * Runs the simulation
	 */
	public void runSimulation() {
		CPU cpu_stat = new CPU();
		if (!queueOfJobs.isEmpty()) {
			Job newJob = (Job) queueOfJobs.remove();
			//This system will work only for 200 minutes
			for (int SystemTime = 0; SystemTime<156; SystemTime++) {
				
				if (cpu_stat.get_remaining_time() == 1) {
					int time = SystemTime - cpu_stat.get_arrival_time();
					waiting_time = time - cpu_stat.getCPUtime();
					System.out.println("Departure\t" + SystemTime + "\t" + String.valueOf(cpu_stat.getPID()) + "\t\t" + String.valueOf(time) + "\t" + String.valueOf(cpu_stat.getLevel()));
					pw.write("Departure\t" + SystemTime + "\t" + String.valueOf(cpu_stat.getPID()) + "\t\t" + String.valueOf(time) + "\t" + String.valueOf(cpu_stat.getLevel()) + "\n");
					total_time_of_all_jobs_in_system = total_time_of_all_jobs_in_system + time;
					cpu_stat = new CPU();
				} 
				cpu_stat.editQuantumClock();
				if (SystemTime == newJob.getArrivalTime()) {
					total_number_of_jobs = total_number_of_jobs + 1;
					System.out.println("Arrival\t" + SystemTime + "\t" + String.valueOf(newJob.getPID()) + "\t" + String.valueOf(newJob.getCpuTimeRequired()));
					pw.write("Arrival\t" + SystemTime + "\t" + String.valueOf(newJob.getPID()) + "\t" + String.valueOf(newJob.getCpuTimeRequired()) + "\n");
					//Are there any jobs running in the CPU?
					if (cpu_stat.get_remaining_time() > 0) {
						Job reducedTimeJob = extract_job_info(cpu_stat, SystemTime);
						//Move the reduced job to a different queue
						move_job_different_level(cpu_stat, reducedTimeJob);
					}
					//For new jobs, the total time in the system is zero and queue1 gets 2 seconds
					cpu_stat.newJob(newJob.getPID(), newJob.getCpuTimeRequired(), 2, newJob.getArrivalTime(), newJob.getCpuTimeRequired());
					//Extract a new job from the queue, and wait till it's time arrives
					if (!queueOfJobs.isEmpty()) {
						newJob = (Job) queueOfJobs.remove();
					}
				} 
				//If the quantum of a job in a specific queue expired, yet it has more time to finish, move the job to a different level 
				//and start the job at the front of the level if any
				else if (cpu_stat.getQuantumClock() == 0) {
					
					Job reducedTimeJob = extract_job_info(cpu_stat, SystemTime);
					if (reducedTimeJob.getTimeRemaining() != 0) {
						cpu_stat= move_job_different_level_and_continue(cpu_stat, reducedTimeJob);
					} 
					else {
					
						if (!queue1.isEmpty()) {
							Job nextJob = (Job) queue1.remove();
							cpu_stat.start_next_level(1, nextJob);
						} else if  (!queue2.isEmpty()) {
							Job nextJob = (Job) queue2.remove();
							cpu_stat.start_next_level(2, nextJob);
						} else if  (!queue3.isEmpty()) {
							Job nextJob = (Job) queue3.remove();
							cpu_stat.start_next_level(3, nextJob);
						}  else if  (!queue4.isEmpty()) {
							Job nextJob = (Job) queue4.remove();
							cpu_stat.start_next_level(4, nextJob);
						} else {
							cpu_idle = cpu_idle + 1;
						}

					}
				}
			}
		}
	}
	

	/**
	 * Method that extracts info regarding the job running in the system
	 * @param cpu_stat
	 * @param SystemTime
	 * @return Job
	 */
	public Job extract_job_info(CPU cpu_stat, int SystemTime) {
		//Extract the pid, current level, and the remaining time for this job to complete and the total time in the system
		int pid = cpu_stat.getPID();
		int remainingTime = cpu_stat.get_remaining_time();
		int arrive_time = cpu_stat.get_arrival_time();
		//Create a reduced job
		Job reducedTimeJob = new Job(arrive_time, pid, remainingTime);
		return reducedTimeJob;
	}
	
	/**
	 * Changes the level of the current running job
	 * @param cpu_stat
	 * @param reducedTimeJob
	 */
	public void move_job_different_level(CPU cpu_stat, Job reducedTimeJob) {
		int currentQueue = cpu_stat.getLevel();
		if (currentQueue == 1) {
			queue2.insert(reducedTimeJob);		
		} else if (currentQueue == 2) {
			queue3.insert(reducedTimeJob);
		} else if (currentQueue == 3) {
			queue4.insert(reducedTimeJob);
		} else if (currentQueue == 4) {
			queue4.insert(reducedTimeJob);
		}
	}
	
	/**
	 * Changes the level of the current running job, starts the next job at the lowest level
	 * @param cpu_stat
	 * @param reducedTimeJob
	 */
	public CPU move_job_different_level_and_continue(CPU cpu_stat, Job reducedTimeJob) {
		int currentQueue = cpu_stat.getLevel();
		if (currentQueue == 1) {
			queue2.insert(reducedTimeJob);
			Job nextJob = (Job) queue2.remove(); 
			cpu_stat.start_next_level(2, nextJob);
		} else if (currentQueue == 2) {
			queue3.insert(reducedTimeJob);
			if (queue2.isEmpty()) {
				Job nextJob = (Job) queue3.remove(); 
				cpu_stat.start_next_level(3, nextJob);
			} else {
				Job nextJob = (Job) queue2.remove();
				cpu_stat.start_next_level(2, nextJob);
			}
		} else if (currentQueue == 3) {
			queue4.insert(reducedTimeJob);
			if (queue3.isEmpty()) {
				Job nextJob = (Job) queue4.remove(); 
				cpu_stat.start_next_level(4, nextJob);
			} else  {
				Job nextJob = (Job) queue3.remove();
				cpu_stat.start_next_level(3, nextJob);
			}
		} else if (currentQueue == 4) {
			queue4.insert(reducedTimeJob);
			Job nextJob = (Job) queue4.remove();
			cpu_stat.start_next_level(4, nextJob);
		}
		return cpu_stat;
	}
	

}
