//creation of student database
import java.sql.*;
class src1{
	public static void main(String[] args) {
		try
		{
			//making the connection happen 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.45.8.8:1521:orcl11g","18071A0547","18071A0547");
			System.out.println("Connection Established.");
			Statement stmt = conn.createStatement();
			//to check the connection is done or not 
			System.out.println("Sql Connection Created.");
			//start creating a table 
			String sql = "create table VNRStudent(id varchar2(20),name varchar2(20),password varchar2(20),email varchar2(40),branch varchar2(10))";
			stmt.executeUpdate(sql);
			//to check there are no faults in this to happen 
			System.out.println("Table Created.");
			//inserting a few students to check the product
			String sql1 = "insert into VNRStudent values('18071A0551','ANURAG','anurag','anuragsajja28@gmail.com','CSE')";
	        String sql2 = "insert into VNRStudent values('18071A0547','SAKETH','saketh','sakethreddy1305@gmail.com','CSE')";
	        String sql3 = "insert into VNRStudent values('18071A0502','AKSHITHA','akshitha','akshithaadepu777@gmail.com','CSE')";
	        String sql4 = "insert into VNRStudent values('18071A0510','SANKRANTHI','sankranthi','sankranthichinthamaneni@gmail.com','CSE')";
	        String sql5 = "insert into VNRStudent values('18071A0528','SAHITHI','sahithi','sahithilatha91221@gmail.com','CSE')";
	        //execute the above queries of inserting the values into the table VNRstudents
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.executeUpdate(sql5);
			//to check if the values are updated properly or not 
			System.out.println("Table data Created.");
			//to check all the values for the last time 
			String sql6 = "select * from VNRStudent";
			ResultSet rs = stmt.executeQuery(sql6);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			//close all the open connections 
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}