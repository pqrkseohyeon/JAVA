package guiTest;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JGugudan  extends JFrame implements ActionListener{
	private JTextField dan; 
	private JTextArea  ta;
	public JGugudan() {
		setTitle("구구단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton btn = new JButton("구구단");
		 dan = new JTextField(10);
		 ta = new JTextArea(10, 20);
		btn.addActionListener(this);
		dan.addActionListener(this);
		add(dan);
		add(btn);
		add(ta);
		
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new JGugudan();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
			//단을 가져와서    for  수행
		try {
			int  d =Integer.parseInt(dan.getText());
			for(int i =1 ;i<10; i++) {
				//System.out.println(d+"*"+i +"="+ d*i);
				ta.append(d+"*"+i +"="+ d*i+"\n");
			}
		}catch(NumberFormatException n) {
			dan.setText("숫자를 입력하세요");
		}
		
	}

}







