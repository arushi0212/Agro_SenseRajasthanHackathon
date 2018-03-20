import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
class login extends Frame implements ActionListener
{
	ResultSet rs;
	TextField t1,t2;
	Button b1,b2;
	int f;
	login()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			Statement st= con.createStatement();
			rs= st.executeQuery("select * from loginfo");
		}catch(Exception e){System.out.println("exception"+e);}
		
		setLayout(null);
		t1=new TextField(40);
		t2=new TextField(40);
		b1=new Button("LOGIN");
		b2=new Button("CANCEL");
		Label l3=new Label("Agro_Sense.com");
		Label l1=new Label("Bhamashah username: ");
		Label l2=new Label("enter your password: ");
		l1.setBounds(50,80,150,40);
		add(l1);
		l1.setForeground(Color.blue);
		l1.setBackground(Color.black);
		l3.setBounds(70,20,150,40);
		add(l3);
		l3.setForeground(Color.blue);
		l3.setBackground(Color.black);
		l2.setBounds(50,120,150,40);
		add(l2);
		l2.setForeground(Color.red);
		l2.setBackground(Color.black);
		t1.setBounds(200,90,80,20);
		add(t1);
		t2.setBounds(200,130,80,20);
		add(t2);
		b1.setBounds(60,180,80,40);
		b1.addActionListener(this);
		add(b1);
		b2.setBounds(160,180,200,40);
		add(b2);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			f=0;
			try{
			while(rs.next())
			{
		 		String name=rs.getString("uname");
		 		String password=rs.getString("pass");
				String un="";
				String pa="";
				un=t1.getText();
				pa=t2.getText();
				System.out.println(un+"      "+ name+"    "+pa+"     "+password+"    "+f);
				if(name.equals(un)&&password.equals(pa))
				{
					String s1=rs.getString("role");
					f f1=new f();
					f1.setVisible(true);
					dispose();
					f=1;
				}
				
			}}catch(Exception e){System.out.println(e);}
			if (f==0)
			{
				form ff=new form();
				ff.setSize(400,500);
				ff.setBackground(Color.black);
				ff.setVisible(true);
				dispose();
			}
			else
				dispose();
		}
	}

}
