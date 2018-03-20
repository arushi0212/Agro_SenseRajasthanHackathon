import java.awt.*;
import java.io.*;

class f extends Frame
{
	f()
	{
		setLayout(null);
		Button b1=new Button("BLUE");
		b1.setForeground(Color.blue);
		b1.setBounds(50,40,60,40);
		Button b2=new Button("GREEN");
		b2.setForeground(Color.green);
		b2.setBounds(50,95,60,40);
		Button b3=new Button("RED");
		b3.setForeground(Color.red);
		b3.setBounds(50,140,60,40);
		Button b4=new Button("GRAY");
		b4.setForeground(Color.gray);
		b4.setBounds(120,40,60,40);
		Button b5=new Button("WHITE");
		b5.setForeground(Color.white);
		b5.setBounds(600,95,60,40);
		Button b6=new Button("yellow");
		b6.setForeground(Color.YELLOW);
		b6.setBounds(560,140,60,40);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
	}
	
}

class menu
{
	public static void main(String args[])
	{
		Font f1=new Font("verdana",Font.BOLD,30);
		f ff=new f();
		ff.setFont(f1);
		ff.setSize(400,500);
		ff.setBackground(Color.black);
		ff.setTitle("Agro_Sense");
		ff.setVisible(true);
		Image icon=Toolkit.getDefaultToolkit().getImage("E:\\iconmenu.png");
		ff.setIconImage(icon);
	}
}