import java.sql.*;
class testdb
{
	public static void main(String args[])
	{
		try{
		String s1=null;
		String s2=null;
		String s3=null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from markstable");
		while(rs.next())
		{
			 s1= rs.getString("uname");
			 s2= rs.getString("pass");
			 s3= rs.getString("role");
			
			System.out.println(s1+"\t"+s2+"\t"+s3);
		}}catch(Exception e){System.out.println(e);}
	}
}