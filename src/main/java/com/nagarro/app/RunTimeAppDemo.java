package com.nagarro.app;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTimeAppDemo {

	public static void main(String[] args) throws IOException {

		// Runtime.getRuntime().exec("C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\Form16.pdf");

		System.out.println("Please enter the filename to be opened:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String filePath = "";

		switch (str) {
		case "java":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\JavaCRUX.docx";
			break;
			
		case "datastructures":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\DataStructuresCRUX.docx";
			break;

		case "java8":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\Java8CRUX.docx";
			break;

		case "spring":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\SpringCRUX.docx";
			break;

		case "hibernate":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\HibernateCRUX.docx";
			break;

		case "springboot":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\SpringBoot_CRUX.docx";
			break;
			
		case "springmicroservices":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\SpringMicroServices_CRUX.docx";
			break;

		case "designpattern":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\DesignPatterns_CRUX.docx";
			break;

		case "exception":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\Exceptions_CRUX.docx";
			break;

		case "multithreading":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\MultithreadingCRUX.docx";
			break;

		case "junit":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\Junit4_CRUX.docx";
			break;

		case "maven":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\MavenCRUX.docx";
			break;

		case "servlet":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\ServletCRUX.docx";
			break;

		case "rabbitmq":
			filePath = "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview\\RabitMQ_CRUX.docx";
			break;

		default:
			System.out.println("invalid name");

		}

		File f = new File(filePath);

		if (!Desktop.isDesktopSupported()) {
			System.out.println("Not supported");
		} else {
			Desktop dt = Desktop.getDesktop();
			if (f.exists()) {
				dt.open(f);
			}
		}

	}

}
