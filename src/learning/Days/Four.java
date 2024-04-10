package learning.Days;
//Implement Thread by implementing Runnable Interface

class OddRunnable implements Runnable {
	@Override
	public void run() {
		for(int i =0;i<10;i++) {
			if(i%2!=0) {
				System.out.println("OddRunnable >>  " + i );
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
//					e.printStackTrace();
					System.out.println("Thread >>> " + Thread.currentThread().getName() + " Interrupted!");
					return;
				}

			}
		}
	}	
}
class EvenThread extends Thread {
	public void run() {
		for(int i =0;i<10;i++) {
			if(i%2==0) {
				System.out.println("EvenThread >>  " + i );
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
//					e.printStackTrace();
					System.out.println("Thread >>> " + Thread.currentThread().getName() + " Interrupted!");
					break;
				}

			}
		}
	}	
}

public class Four {
	//Thread Challenge
	public static void main(String[] args) {
		EvenThread evenRunnable = new EvenThread();
		Thread oddThread = new Thread(new OddRunnable());
		evenRunnable.start();
		oddThread.start();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		//Thread printing even numbers interrupted after 1 sec
		evenRunnable.interrupt();


	}

}
