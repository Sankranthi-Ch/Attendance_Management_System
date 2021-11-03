import java.sql.*;
import java.util.*;
class src3{
	public static void main(String[] args) {
		try
		{
			int count=0;
			//making the connection happen 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.45.8.8:1521:orcl11g","18071A0547","18071A0547");
			System.out.println("Connection Established.");
			Statement stmt = conn.createStatement();
			Statement stmt1 = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			Statement stmt3 = conn.createStatement();
			Statement stmt5 = conn.createStatement();
			//to check the connection is done or not 
			System.out.println("Sql Connection Created.");
			System.out.println("Select one of the options given below");
			System.out.println("1.STUDENT");
			System.out.println("2.PROFESSOR");
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			if(ch==2)
			{
				/////faculty plays here
				System.out.print("Enter your respective branch : ");
				String b=sc.next();
				String sql="select * from "+b;
				ResultSet rs=stmt.executeQuery(sql);
				ResultSetMetaData rsmd=rs.getMetaData();
				for(int i=4;i<=rsmd.getColoumnCount();i++)
				{
					System.out.println(rsmd.getColoumnName(i));
				}
				Sytem.out.print("Enter your subject Code : ");
				String s=sc.next();
				System.out.println("give a yes or no by Y/N adjacent to each Student ");
				while(rs.next())
				{
						System.out.print(rs.getString(1)+"\t"+rs.getString(2)+" : ");
						String ap=sc.next();
						if(ap=='Y')
						{
							String cmd="update table "+b+" set "+s+"="+s+"+1 where id like "+rs.getString(1);
							ResultSet pq=stmt2.executeUpdate(cmd);
						}
				}
				String cmd="update table "+b+" set Total=Total+1";
				ResultSet er=stmt5.executeUpdate(cmd);
				pq.close();
				rs.close();
				rsmd.close();
				stmt.close();
				stmt5.close();
				stmt2.close();

			}
			else
			{

				System.out.print("Enter your ID : ");
				String id = sc.next();
				System.out.print("Enter your password : ");
				String pwd = sc.next();
				String sql1 = "select * from VNRStudent where id like "+id;
				ResultSet ep=stmt3.executeQuery(sql1);
				String branch=ep.getString(5);
				String sq="select * from "+branch+ " where id like "+id;
				ResultSet qw=stmt1.executeQuery(sq);
				ResultSetMetaData rsm=qw.getMetaData();
				for(int i=1;i<=rsm.getColoumnCount();i++)
				{
					System.out.print(rsm.getColoumnName(i)+"\t");
				}
				for(int i=1;i<=rsm.getColoumnCount();i++)
				{
					System.out.print(qw.getString(i)+"\t");
				}
				System.out.print("Your attendance % is : ");
				float per=0;
				float count=0;
				for(int i=4;i<rsm.getColoumnCount();i++)
				{
					count+=Float.parseFloat(qw.getString(i));
				}
				per=count/(Float.parseFloat(qw.getString(rsm.getColoumnCount)));
				System.out.println(per);
				stmt5.close();
				stmt3.close();
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}