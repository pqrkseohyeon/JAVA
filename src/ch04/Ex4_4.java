package ch04;

public class Ex4_4 {

	public static void main(String[] args) {
		int sum = 0; // ������ ������ ����
		int s = 1; // ���� ��ȣ�� �ٲ��ִµ� ����� ����
		int num = 0;
		
		//���ǽ��� ���� true �̹Ƿ� ���ѹݺ����� �ȴ�.
		for(int i=1; true ; i++, s=-s) { // �� �ݺ����� s�� ���� 1, -1, 1, -1 ...
			num = s * i; // i�� ��ȣ(s)�� ���ؼ� ���� ���� ���Ѵ�.
			sum += num;
			
			if(sum >= 100) // ������ 100���� ���ų� ũ�� �ݸ��� ���� ������.
				break;
		}
		
		System.out.println("num =" + num);
		System.out.println("sum = " + sum);
	}

}
