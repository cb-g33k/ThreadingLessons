package ThreadEx1;

class StoppedThread extends Thread {
	
    public void run() {
    	for( ;; ) {
    		if (interrupted()) {
    			System.out.println("Thread is interrupted hence stopping..");
    			break;
    		}	
    		System.out.print("T");
		}	
    }
}

public class Lesson3 {
	public static void main(String[] args) {
		 
		StoppedThread thr = new StoppedThread();
		thr.start();
		try {
		    Thread.sleep(2000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}	
		thr.interrupt();
	}
}
