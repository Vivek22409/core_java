package com.nagarro.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {
	
	public static void main(String[] arg) throws IOException, ClassNotFoundException {
		
		FileInputStream fIn = new FileInputStream(new File("C:\\Users\\vivekkumar02\\Desktop\\Xtra\\serial.txt"));
		ObjectInputStream objIn = new ObjectInputStream(fIn);
		//******Java 7 or 8 bug here 
		try(FileInputStream fIn1 = fIn;ObjectInputStream objIn1=objIn){
			
			WoodenTable t = (WoodenTable)objIn.readObject();
			
			System.out.println(t.getStatEg());			
			
			System.out.println("Deserialized...");
			
		}
		
	}

}
