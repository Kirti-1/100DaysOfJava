package learning.Days;


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
		 * 
		 */
		
		
		
		//Let's create another thread and then interrupt it after some time.
		Thread thread = new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.print(" . ");
				try {
					Thread.currentThread().sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
		});
		thread.start();
		System.out.println("Main Thread!");
		
		try {				
			Thread.sleep(1000);
			//interrupted thread after 1 sec the output will be - . . . . 
			thread.interrupt();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		System.out.println();		
		System.out.println("Main Thread Ended!");
	}
	
}
