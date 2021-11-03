//creation of student database
import java.sql.*;
import java.util.*;
class src2{
	public static void main(String[] args) {
		try
		{
			Scanner sc=new Scanner(System.in);
			//making the connection happen 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.45.8.8:1521:orcl11g","18071A0547","18071A0547");
			System.out.println("Connection Established.");
			Statement stmt1 = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			Statement stmt3 = conn.createStatement();
			Statement stmt4 = conn.createStatement();
			//to check the connection is done or not 
			System.out.println("Sql Connection Created.");
			//first to know the each subject for each branch
			Hashset<String>hs=new Hashset();
			ResultSet a=stmt2.executeQuery("select branch from VNRStudent");
			while(a.next())
			{
				hs.add(a.getString(1));
			}
			//creating a table for each respective branch
			for(String i:hs)
			{
				Sytem.out.println("enter number of subjects for "+i);
				int subjects=sc.nextInt();
				int sub=subjects;
				String sql = "create table "+i+"(id varchar2(20),name varchar2(20),branch varchar2(5)";
				String option=i;
				while(subjects)
				{
					System.out.print("Enter Subject Code : ");
					String subcode=sc.next();
					sql+=","+subcode+" number(3)";
					subjects-=1;
				}
				sql+=" ,Total number(3))";
				stmt2.executeUpdate(sql);
				//tables are created here 
				int sab=sub;
				ResultSet b=stmt1.executeQuery("select id,name,branch from VNRStudent");
				while(b.next())
				{
					if(b.getString(2)==i)
					{
						String ql="insert into "+option+" values("+b.getString(1)+","+b.getString(2)+","+b.getString(3);
						while(sub>0)
						{
							ql+=",0";
							sub-=1;
						}
						ql+=",0)";
					ResultSet c=stmt3.executeUpdate(ql);
					}
				}
				
			}
			c.close();
			b.close();
			a.close();
			stmt2.close();
			stmt1.close();
			stmt3.close();
			stmt4.close();
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}