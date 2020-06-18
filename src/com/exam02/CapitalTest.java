package com.exam02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;




public class CapitalTest {
	public static Scanner sc = new Scanner(System.in);
	private HashMap<String, String> map = new HashMap<String, String>();
	File dir, file;
	
	public CapitalTest() {
		dir = new File("src\\com\\exam02");
		file = new File(dir, "myCapitalTest.txt");
		map.clear();
		try {
		if(!file.exists()) {//파일없음
				file.createNewFile();//파일생성
				return;
			 }
				Scanner scanner = new Scanner(file);
				while(scanner.hasNext()) {
					String country = scanner.next(); //나라
					String capital = scanner.next(); //수도
					map.put(country, capital);
				}
				scanner.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
	public static void showMenu() {
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		System.out.println("1.입력, 2.퀴즈, 3.파일저장  및 종료");
			
	}
	

	
	public void input() {
		System.out.println("현재" + map.size() + " 개 나라와 수도 입력");
		while(true) {
			System.out.println("나라와 수도 입력(종료는 X)>>");
			String cont =sc.next();
			if(cont.toUpperCase().equals("X"))break;
			if(map.containsKey(cont)==true) {
				System.out.println("이미 입력한 나라입니다.");
				continue;
			}
			String sudo = sc.next();
			map.put(cont, sudo);
		}
		
	}
	
	public void quiz() {
		Set<String> set = map.keySet();
		Object[] arr = set.toArray();
		while(true) {
			int n=(int)(Math.random()*map.size());
			String city ="";
			try {
			 city = (String)arr[n];
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("map 이 비어 있습니다.");
				return;
			}
			String dosi = map.get(city);
			
			System.out.println(city + " 의 수도는 ? 종료는  x >>");
			String answer = sc.next();
			if(answer.toLowerCase().equals("x")) {
				System.out.println("종료합니다.");
			break;
			}
			if(answer.equals(dosi)) {
				System.out.println("정답");
			}else {
				System.out.println("틀렸습니다.");
			}
		}
		
		
	}
	
	public void save() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String key = it.next();
				String value = map.get(key);
				fw.write(key+" ");
				fw.write(value+"\n");
			}
			fw.close();
			System.out.println("종료");
			System.exit(0);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("파일저장 오류");
		}
		
	}

	public static void main(String[] args) {
		CapitalTest ct = new CapitalTest();	
		while(true) {
			CapitalTest.showMenu();
			int choice = CapitalTest.sc.nextInt();
			switch(choice) {
			case 1 : ct.input(); break;
			case 2 : ct.quiz(); break;
			case 3 : ct.save();  break;
			default : System.out.println("입력오류");
			}
	}
}
}
