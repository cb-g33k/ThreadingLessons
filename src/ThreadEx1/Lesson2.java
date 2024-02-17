package ThreadEx1;

import java.io.IOException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CopyTask implements Runnable{
	private String sourceFile, destFile;
	public CopyTask(String src, String dest) {
		sourceFile = src;
		destFile = dest;
	}

	@Override
	public void run() {
		try {
			IOUtils.copyFile(sourceFile,  destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class Lesson2 {
	public static void main(String[] args) throws IOException {
		String sourceFile1 = "a.txt";
		String sourceFile2 = "b.txt";
		
		String destFile1 = "c.txt";
		String destFile2 = "d.txt";
		
		/*
		FileInputStream fin = new FileInputStream(sourceFile);
		FileOutputStream fout = new FileOutputStream(destFile);
		
		IOUtils.copy(fin, fout);
		
		System.out.println("Fin");
		
		fin.close();
		fout.close();
		*/
		
		/*
		IOUtils.copyFile(sourceFile1,  destFile1);
		IOUtils.copyFile(sourceFile2, destFile2);
		*/
		
		/*
		Thread t1 = new Thread(new CopyTask(sourceFile1, destFile1));
		Thread t2 = new Thread(new CopyTask(sourceFile2, destFile2));
		t1.start();
		t2.start();
		*/
		
		ExecutorService eService = Executors.newFixedThreadPool(5);
		eService.execute(new CopyTask(sourceFile1, destFile1));
		eService.execute(new CopyTask(sourceFile2, destFile2));
	}
}
