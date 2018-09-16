package com.nagarro.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	
	public static void main(String[] arg) throws IOException {
		
		FileOutputStream fOut = new FileOutputStream(new File("C:\\Users\\vivekkumar02\\Desktop\\Xtra\\serial.txt"));
		ObjectOutputStream objOut = new ObjectOutputStream(fOut);
		//******Java 7 or 8 bug here 
		try(FileOutputStream fOut1 = fOut;ObjectOutputStream objOut1=objOut){
			
			objOut.writeObject(new WoodenTable(12,10,4,"wood"));
			
			System.out.println("Serialized...");
			
		}
		
	}

}
