package programming.injava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * we have 5 philosophers who need to eat lunch. Additionally, we have one table that can simultaneously accommodate 
 * no more than two people. Our task is to feed all the philosophers. None of them should go hungry, 
 * and none of them should "block" each other when trying to sit down at the table (we must avoid deadlock). 
 * 
 * */
public class SemaphorePhilosopher {

	public static void main(String[] args) {
		Semaphore table = new Semaphore(2);
		
		Philosopher p1 = new Philosopher(table, "Ram");
		Philosopher p2 = new Philosopher(table, "Shyam");
		Philosopher p3 = new Philosopher(table, "Shivaay");
		Philosopher p4 = new Philosopher(table, "Ritu");
		Philosopher p5 = new Philosopher(table, "Deepak");
		Philosopher p6 = new Philosopher(table, "Rudra");
		
		ExecutorService threadpool = Executors.newFixedThreadPool(5);
		threadpool.submit(p1);
		threadpool.submit(p2);
		threadpool.submit(p3);
		threadpool.submit(p4);
		threadpool.submit(p5);
		threadpool.submit(p6);
		
	}

}


class Philosopher implements Runnable{
	
	Semaphore accessTable;
	String name;
	
	boolean hasServed = false;

	public Philosopher(Semaphore accessTable, String name) {
		super();
		this.accessTable = accessTable;
		this.name = name;
	}

	@Override
	public void run() {
		if(!hasServed) {
			try {
				accessTable.acquire();
				
				System.out.println(Thread.currentThread().getName() + " - Serving the food started for philosopher: " + name);
				
				Thread.sleep(200);
				
				System.out.println(Thread.currentThread().getName() + " - Philosopher: " + name + " has finished the food");
				
				hasServed = true;
				
				accessTable.release();
				
				Thread.sleep(200);
				
			} catch (InterruptedException e) {
				System.out.println("Error has occurred while serving philosopher: " + name + e.getLocalizedMessage());
			}
		}
	}
}