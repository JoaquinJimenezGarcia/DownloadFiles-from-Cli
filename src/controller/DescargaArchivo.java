package controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import model.FileDownloaded;

public class DescargaArchivo {
	Scanner input = new Scanner (System.in);
	String fileUrl, fileName;
	String folder = "downloads/"; 
	File dir, file;
	FileDownloaded download;
	
	public void start() throws IOException {
		createFileProperties();
		
		dir = new File(folder);
		createFolder();
		
		file = new File(folder + download.getName());
		
		connection(fileUrl, fileName);
		
	}
	
	public FileDownloaded createFileProperties() {
		System.out.println("File name: ");
		fileName = input.nextLine();
		
		System.out.println("File url: ");
		fileUrl = input.nextLine();
		
		return download = new FileDownloaded(fileUrl, fileName);
	}
	
	public void createFolder() {
		if (!dir.exists()) {
			if (!dir.mkdir()) {
				return; 
			}
		}
	}
	
	public void connection(String url, String name) throws IOException {
		URLConnection conn = null;
		try {
			conn = new URL(url).openConnection();
			System.out.println("Established connection");
		} catch (IOException e) {
			System.out.println("The URL seems not to be correctly written.");
		}
		try {
			conn.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection lost.");
		}
		
		System.out.println("\nStarting download: \n");
		System.out.println(">> URL: " + url);
		System.out.println(">> Name: " + name);
		System.out.println(">> Size: " + conn.getContentLength() + " bytes");
		
		InputStream in = conn.getInputStream();
		OutputStream out = new FileOutputStream(file);
		
		int b = 0;
		while (b != -1) {
		  b = in.read();
		  if (b != -1)
		    out.write(b);
		}
		
		out.close();
		in.close();
		
		System.out.println("Search your downloaded items in the downloads folder of the app.");
		
		System.exit (0);
	}
}
