package com.nagarro.singleton;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class TestSingleton {
	public static void main(String[] arg) throws InterruptedException, ExecutionException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException, CloneNotSupportedException {
		//System.out.println(SingletonWithEagerInitiallization.getInstance().hashCode());
		//System.out.println(SingletonWithEagerInitiallization.getInstance().hashCode());
		//Perfect1	
		
		//Perfect broke singleton pattern and made it safe#######################
		/*ExecutorService es = Executors.newFixedThreadPool(5);
		
		BreakSingletonWithThread[] bs = new BreakSingletonWithThread[10];
		
		List<Future<SingletonWithLazyInitiallization>> list = new ArrayList<>();
		for(int i = 0; i<5;i++) {
			bs[i] = new BreakSingletonWithThread();
			Future<SingletonWithLazyInitiallization> f = es.submit(bs[i]);
			list.add(f);
		}
		es.shutdown();
		for(Future<SingletonWithLazyInitiallization> f: list) {
			SingletonWithLazyInitiallization swi = f.get();
			System.out.println("ClassName: "+swi.getClass().getName()+" with Hashcode "+swi.hashCode());
		}*/
		
		//break singleton with reflection api##########################################
		/*SingletonWithEagerInitiallization swei1 = SingletonWithEagerInitiallization.getInstance();
		SingletonWithEagerInitiallization swei2 = null;
		
		Constructor[] constctrs= SingletonWithEagerInitiallization.class.getDeclaredConstructors();
		for(Constructor c:constctrs) {
			c.setAccessible(true);
			swei2 = (SingletonWithEagerInitiallization) c.newInstance();
		}
		
		System.out.println(swei1.hashCode());
		System.out.println(swei2.hashCode());*/
		
		//BillPughSingleton
		//System.out.println(BillPughSingleton.getSingleton());
		//System.out.println(BillPughSingleton.getSingleton());
		
		//With ENUM#####################################
		//EnumSafeSingleton ess = EnumSafeSingleton.INSTANCE;
		
		//System.out.println(ess.getInstance().getClass().hashCode());
		//System.out.println(ess.getInstance().getClass().hashCode());
		
		//Serialization safe demo######################################
		/*SingletonWithEagerInitiallization swei3 = SingletonWithEagerInitiallization.getInstance();
		SingletonWithEagerInitiallization swei4 =null;
		
		try(FileOutputStream fOut = new FileOutputStream(new File("C:\\Users\\vivekkumar02\\Desktop\\Xtra\\serial.txt"));
				ObjectOutputStream bfOut = new ObjectOutputStream(fOut);
				FileInputStream fIn = new FileInputStream(new File("C:\\Users\\vivekkumar02\\Desktop\\Xtra\\serial.txt"));
				ObjectInputStream bIn = new ObjectInputStream(fIn);){
				
			bfOut.writeObject(swei3);
			
			swei4 = (SingletonWithEagerInitiallization) bIn.readObject();					
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		System.out.println(swei3.hashCode());
		System.out.println(swei4.hashCode());*/
		
		/* with clone safety ######################################
		SingletonWithEagerInitiallization swei5 = SingletonWithEagerInitiallization.getInstance();
		SingletonWithEagerInitiallization swei6 =  (SingletonWithEagerInitiallization) swei5.clone();
		
		System.out.println(swei5.hashCode());
		System.out.println(swei6.hashCode());*/
	}
}
