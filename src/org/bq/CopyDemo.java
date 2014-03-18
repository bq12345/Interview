package org.bq;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\bq.c"));
			FileWriter fw = new FileWriter("D:\\bq.txt");
			String s = "";
			while ((s=br.readLine()) != null) {
				fw.write(s+"\r\n");
			}
			br.close();
			fw.close();
			InputStream in = new FileInputStream("D:\\2.png");
			OutputStream out = new FileOutputStream("D:\\3.png");
			byte[] b = new byte[1024];
			while (in.read(b) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
