import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
class form extends Frame implements ActionListener
{
	
	form()
	{
		setLayout(null);
		Button b1=new Button("");
		b1.setBounds(150,200,100,70);
		b1.addActionListener(this);
		add(b1);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		login mm=new login();
		mm.setSize(400,500);
		mm.setVisible(true);
		mm.setBackground(Color.black);
		dispose();
		
	}
}

class hom
{
	public static void main(String args[])
	{
		form fm=new form();
		fm.setSize(400,500);
		fm.setBackground(Color.blue);
		fm.setTitle("AGRO_SENSE");
		fm.setVisible(true);
		
	}
}




		