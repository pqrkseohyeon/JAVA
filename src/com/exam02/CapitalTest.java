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
		if(!file.exists()) {//���Ͼ���
				file.createNewFile();//���ϻ���
				return;
			 }
				Scanner scanner = new Scanner(file);
				while(scanner.hasNext()) {
					String country = scanner.next(); //����
					String capital = scanner.next(); //����
					map.put(country, capital);
				}
				scanner.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
	public static void showMenu() {
		System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
		System.out.println("1.�Է�, 2.����, 3.��������  �� ����");
			
	}
	

	
	public void input() {
		System.out.println("����" + map.size() + " �� ����� ���� �Է�");
		while(true) {
			System.out.println("����� ���� �Է�(����� X)>>");
			String cont =sc.next();
			if(cont.toUpperCase().equals("X"))break;
			if(map.containsKey(cont)==true) {
				System.out.println("�̹� �Է��� �����Դϴ�.");
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
				System.out.println("map �� ��� �ֽ��ϴ�.");
				return;
			}
			String dosi = map.get(city);
			
			System.out.println(city + " �� ������ ? �����  x >>");
			String answer = sc.next();
			if(answer.toLowerCase().equals("x")) {
				System.out.println("�����մϴ�.");
			break;
			}
			if(answer.equals(dosi)) {
				System.out.println("����");
			}else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
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
			System.out.println("����");
			System.exit(0);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("�������� ����");
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
			default : System.out.println("�Է¿���");
			}
	}
}
}
