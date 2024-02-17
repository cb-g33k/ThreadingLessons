package ThreadEx1;

class MyThread extends Thread{
	public void run() {
		int k = 0;
		for(int i = 0; i < 100; i++) {
			k += Math.sqrt(i);
			System.out.println(k);
		}
	}
}

//prefereable as it implements the interfacerather than adding functionality to the thread class
class MyTask implements Runnable{
	@Override
	public void run() {
		int k = 0;
		for(int i = 0; i < 100; i++) {
			k += Math.sqrt(i);
			System.out.println(k);
		}
	}
	
}

public class Lesson1 {
	public static void main(String args[]) {
		MyThread thread = new MyThread();
		MyTask task = new MyTask();
		Thread thread2 = new Thread(task);
		thread.start();
		thread2.start();
		
	}
}
