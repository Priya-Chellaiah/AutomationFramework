package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class SampleExecuteQueryJDBC {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		//step1:register the driver
		DriverManager.registerDriver(driver);
		
		//step2:get the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		
		//step3:issue create statement
		Statement state = con.createStatement();
		//step4:execute any query
		
//		ResultSet result = state.executeQuery("select * from employeeinfo;");
//		while(result.next()) {
//			String value = result.getString(1);
//			System.out.println("result is:"+value);
//		}
		//step4:execute any query- provide table name
		String query="Insert into employeeinfo values('Spiderman','USA',110),('Batman','USA',120),('Superman','Uae',130);";
		int result = state.executeUpdate(query);
		if(result==3) {
			System.out.println("data added successfully");
		}
		else {
			System.out.println("Record not inserted successfully");
		}
		
		
		//step5:close the database
		con.close();

	}

}
