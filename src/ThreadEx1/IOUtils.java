package ThreadEx1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	public static void copy(InputStream in, OutputStream out) throws IOException {
		int value;
		while((value = in.read()) != -1) {
			out.write(value);
		}
	}
	public static void copyFile(String src, String dest) throws IOException {
		FileInputStream fin = new FileInputStream(src);
		FileOutputStream fout = new FileOutputStream(dest);
		
		IOUtils.copy(fin, fout);
		
		System.out.println("Fin");
		
		fin.close();
		fout.close();
	}
}
