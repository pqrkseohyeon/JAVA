package guiTest;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CheckBoxTest_inner  extends JFrame{
	private JTextArea ta;
	public CheckBoxTest_inner() {
		setTitle("CheckBoxTest_inner");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1= new JPanel();
		 ta = new JTextArea();
		 JCheckBox cb1 = new JCheckBox("바나나");
		 JCheckBox cb2 = new JCheckBox("오렌지");
		 JScrollPane jsp = new JScrollPane(ta);
		p1.add(cb1);		p1.add(cb2);
		ItemEventH ih = new ItemEventH(ta);
		cb1.addItemListener(ih);
		cb2.addItemListener(ih);
		add(BorderLayout.NORTH, p1);
		add(BorderLayout.CENTER,jsp);
		setSize(400, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxTest_inner();
	}
}
