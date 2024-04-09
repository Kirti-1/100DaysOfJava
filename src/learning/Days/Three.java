package learning.Days;


//Implementation of threads by extending 'Threads' class

public class Three extends Thread {
	
	//Counter function from 1 to 10
	public static void counter() {
		for(int i=1;i<=10;i++) {
			try {				
				System.out.print(i + " ");
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println();	
	}
	
	
	public static void main(String[] args) {
		/**
		 *  **************************  Studying threads ********************************
		 * 	A thread is a single execution unit performing some task, threads allows us to process multiple task simultaneously
		 *	allowing our program to act more efficient and a multitasker.
		 *	You can create a thread either by extending the 'Thread' class or by implementing the Runnable interface.
		 *	Threads represent separate path of execution within a program.
		 *	Different States of threads -- New,Runnable,blocked,waiting,timed waiting, or terminated.
		 * 
		 */
		
		
		
		//Let's create another thread and then interrupt it after some time.
		Thread thread = new Thread(()->{
			for(int i=0;i<10;i++) {
				String tname = Thread.currentThread().getName();
				String state = Thread.currentThread().getState().toString();
				
				System.out.print(" . ");
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
				System.out.println(tname + i +  "  <<< with state >>> " + state);
			}
		});
		
		//This is how we start a thread -- this internally call Thread's run() method which contains the thread's code. 
		thread.start();
		System.out.println("Main Thread!");
		

		String mname = Thread.currentThread().getName();
		String mstate = Thread.currentThread().getState().toString();

		String tname = thread.getName();
		String state = thread.getState().toString();
		try {				
			Thread.sleep(1000);
			//interrupted thread after 1 sec the output will be - . . . . 

			//after 1 sec the state of thread-0 was in blocked state as it has been blocked as sleep time main thread got finished, now main thread will execute.
			
			System.out.println(tname  + "  <<< with state >>> " + state);
			System.out.println(mname  + "  <<< with state >>> " + mstate);
			
			
//			thread.interrupt();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		/* Output of above code -- with thread name and its state
		 Main Thread!
		 . Thread-00  <<< with state >>> RUNNABLE
		 . Thread-01  <<< with state >>> RUNNABLE
		 . Thread-02  <<< with state >>> RUNNABLE
		 . Thread-0  <<< with state >>> BLOCKED
		main  <<< with state >>> RUNNABLE
		
		Main Thread Ended!
		Thread-03  <<< with state >>> RUNNABLE
		 . Thread-04  <<< with state >>> RUNNABLE
		 . Thread-05  <<< with state >>> RUNNABLE
		 . Thread-06  <<< with state >>> RUNNABLE
		 . Thread-07  <<< with state >>> RUNNABLE
		 . Thread-08  <<< with state >>> RUNNABLE
		 . Thread-09  <<< with state >>> RUNNABLE
		 */
		
		System.out.println();		
		System.out.println("Main Thread Ended!");
	}
	
}
