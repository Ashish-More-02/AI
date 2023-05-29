// Java code for the above approach

import java.util.*;

class Job_scheduling {

	// Each job has a unique-id,profit and deadline
	char id;
	int deadline, profit;

	// Constructors
	public Job_scheduling() {}

	public Job_scheduling(char id, int deadline, int profit)
	{
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	// Function to schedule the jobs take 2 arguments
	// arraylist and no of jobs to schedule
	void printJobScheduling(ArrayList<Job_scheduling> arr, int t)
	{
		// Length of array
		int n = arr.size();
	
		// Sort all jobs according to decreasing order of
		// profit
		Collections.sort(arr,
						(a, b) -> b.profit - a.profit);

		// To keep track of free time slots
		boolean result[] = new boolean[t];

		// To store result (Sequence of jobs)
		char job[] = new char[t];

		// Iterate through all given jobs
		for (int i = 0; i < n; i++) {
			// Find a free slot for this job (Note that we
			// start from the last possible slot)
			for (int j
				= Math.min(t - 1, arr.get(i).deadline - 1);
				j >= 0; j--) {
				// Free slot found
				if (result[j] == false) {
					result[j] = true;
					job[j] = arr.get(i).id;
					break;
				}
			}
		}

		// Print the sequence
		for (char jb : job)
			System.out.print(jb + " ");
		System.out.println();
	}

	// Driver's code
	public static void main(String args[])
	{
		ArrayList<Job_scheduling> arr = new ArrayList<Job_scheduling>();
		arr.add(new Job_scheduling('a', 2, 100));
		arr.add(new Job_scheduling('b', 1, 19));
		arr.add(new Job_scheduling('c', 2, 27));
		arr.add(new Job_scheduling('d', 1, 25));
		arr.add(new Job_scheduling('e', 3, 15));

		System.out.println(
			"Following is maximum profit sequence of jobs");

		Job_scheduling job = new Job_scheduling();

		// Function call
		job.printJobScheduling(arr, 3);
	}
}

// This code is contributed by Aditya Kumar (adityakumar129)
