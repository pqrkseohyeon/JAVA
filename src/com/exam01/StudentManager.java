package com.exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Student> arr = new ArrayList<Student>();
	File dir,file;
	public StudentManager() throws IOException, ClassNotFoundException{
		dir = new File("src\\com\\exam01");
		file = new File(dir, "studentMa.txt");
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			arr = (ArrayList<Student>)ois.readObject();
			
		}else {
			file.createNewFile();
		}

	}
	private void fileUse() throws FileNotFoundException, IOException{
		Scanner sc =  new Scanner(System.in);
		
	}
	
	
		

	
	public static void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1.������ �Է�");
		System.out.println("2.��ü����");
		System.out.println("3.�л�ã��");
		System.out.println("4.����/����");
		System.out.println("���� : ");
		
	}
	
	public void inputData() {
		while(true) {
			System.out.println("�л� �̸�, �а�, �й�, �������,(�Է��� , �� �����ϰ� ����� x)");
			System.out.println(">>");
			String text = StudentManager.sc.nextLine();
			if(text.toLowerCase().equals("x")) {
				System.out.println("�Է�����");
				break;
			}
			try {
				StringTokenizer st = new StringTokenizer(text,",");
				String name = st.nextToken();//�̸�
				String department = st.nextToken();//�а�
				String id = st.nextToken();//�й�
				double grade = Double.parseDouble(st.nextToken());//����
				arr.add(new Student(name, department, id, grade));
				
			}catch (Exception e) {
				System.out.println("�ٽ��Է� �ϼ���");
			}
			
		}


		
	}
	
	public void viewData() { 
		System.out.println("�л� ��ü ����Ʈ....");
		for(Student student : arr) {
			System.out.println("�̸� : " + student.getName());
			System.out.println("�а� : " + student.getDepartment());
			System.out.println("�й� : " + student.getId());
			System.out.println("���� ��� : " + student.getGrade());
			System.out.println();
		}
	}
	
	public void searchData() {
		System.out.println("�л� ã��...");
		System.out.println("ã�� �л� �̸�>>");
		String searchName = StudentManager.sc.next();
		Student s = search(searchName);
		if(s==null) {
			System.out.println("ã�� �л� ����");
			return;
		}
		System.out.println("�̸� : " + s.getName());
		System.out.println("�а� : " + s.getDepartment());
		System.out.println("�й� : " + s.getId());
		System.out.println("���� ��� : " + s.getGrade());
	}
	private Student search(String searchName) {
		for(int i =0;i<arr.size();i++){
			if(searchName.contentEquals(arr.get(i).getName())) {
				return arr.get(i);
			}
			
		}
		return null;
		
		
	}
	public void saveData() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		try {
			oos.writeObject(arr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����");
		System.exit(0);
			

		
	}
	

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		StudentManager sm = new StudentManager();
		sm.fileUse();
		while(true) {
			StudentManager.showMenu();
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 1 : sm.inputData();break;
			case 2 : sm.viewData(); break;
			case 3 : sm.searchData(); break;
			case 4 : sm.saveData();
			System.out.println("���α׷� ����");
			System.exit(0);
			default : System.out.println("�Է¿���");
			}
		}
	}


}
