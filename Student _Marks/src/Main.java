
import java.awt.Color;
import java.sql.*;

public class Main {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	int tempMarks[]=new int[6];
	String allDetails;
	
	Main(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment","root","mysql@DK.01");
			stmt=conn.createStatement();
		}
		catch(SQLException e) {
			MainFrame.status.setForeground(Color.RED);
			MainFrame.status.setText(e.getMessage());
		}
		catch(Exception f) {
			MainFrame.status.setForeground(Color.RED);
			MainFrame.status.setText(f.getMessage());
		}
	}
	
	
	
	static String sub(String str) {
		switch(str) {
		case "Subject 1":{
			return "s1";
		}
		case "Subject 2":{
			return "s2";
		}
		case "Subject 3":{
			return "s3";
		}
		case "Subject 4":{
			return "s4";
		}
		case "Subject 5":{
			return "s5";
		}
		case "Subject 6":{
			return "s6";
		}
		default:{
			return "Error";
		}
		}
	}
	
	static String ways(String str) {
		switch(str) {
		case "Name":{
			return "name";
		}
		case "Register no":{
			return "regno";
		}
		default:{
			return "Error";
		}
		}
	}
	
	static String tests(String str) {
		switch(str) {
		case "CA Test 1":{
			return "catest1";
		}
		case "CA Test 2":{
			return "catest2";
		}
		case "CA Test 3":{
			return "catest3";
		}
		default :{
			return "Error";
		}
		}
	}
	
	static String size(String str,int n) {
		
		while(str.length()!=n) {
			str=str+"_";
		}
		System.out.println(str+".");
		return str;
	}
	
	void insert(String studentname,String regno,String test,int mark1,int mark2,int mark3,int mark4,int mark5,int mark6) {
	
		test=Main.tests(test);
		allDetails="insert into "+test+" values('"+studentname+"','"+regno+"',"+mark1+","+mark2+","+mark3+","+mark4+","+mark5+","+mark6+");";
		
		try {
			rs=stmt.executeQuery("select * from "+test+" where regno='"+regno+"';");
			
			if(rs.next()) {
				MainFrame.status.setForeground(Color.RED);
				MainFrame.status.setText("Student with this register number is already exist try update");
			}
			else {
				stmt.execute(allDetails);
				MainFrame.status.setForeground(Color.GREEN);
				MainFrame.status.setText("Successfully Inserted");
			}
			
		} catch(SQLException f) {
			MainFrame.status.setForeground(Color.RED);
			MainFrame.status.setText(f.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void update(String regno,String exam,String subject,int mark) {
		
		exam=Main.tests(exam);
		subject=Main.sub(subject);
		allDetails="update "+exam+" set "+subject+"="+mark+" where regno='"+regno+"';";
		
		try {
			rs=stmt.executeQuery("select * from "+exam+" where regno='"+regno+"';");
			if(rs.next()){
				stmt.execute(allDetails);
				MainFrame.status.setForeground(Color.GREEN);
				MainFrame.status.setText("Successfully Updated");
			} else {
				MainFrame.status.setForeground(Color.RED);
				MainFrame.status.setText("Register number not Found");
			}
			
		} catch(SQLException f) {
			MainFrame.status.setForeground(Color.RED);
			MainFrame.status.setText(f.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	synchronized String search(String regno,String test) {
		test=Main.tests(test);
		allDetails="select * from "+test+" where regno='"+regno+"';";
		
		try {
			rs=stmt.executeQuery(allDetails);
			
			if(rs.next()) {
				tempMarks[0]=rs.getInt(3);
				tempMarks[1]=rs.getInt(4);
				tempMarks[2]=rs.getInt(5);
				tempMarks[3]=rs.getInt(6);
				tempMarks[4]=rs.getInt(7);
				tempMarks[5]=rs.getInt(8);
				MainFrame.status.setText("");
				return rs.getString(1);
			}
			else {
				MainFrame.status.setForeground(Color.RED);
				MainFrame.status.setText("Register number not found");
				
				for(int i=0;i<6;i++) {
					tempMarks[i]=0;
				}
				return "";
			}
			
		} catch(SQLException f) {
			MainFrame.status.setForeground(Color.RED);
			MainFrame.status.setText(f.getMessage());
			return "";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	String view(String test) {
		String tmp=test;
		test=Main.tests(test);
		allDetails="select * from "+test;
		
		try {
			rs=stmt.executeQuery(allDetails);
			allDetails="";
			
			if(rs.next()){
				allDetails=allDetails+Main.size(rs.getString(1),20)+rs.getString(2)+"\t"+rs.getInt(3)+"     "+rs.getInt(4)+"     "+rs.getInt(5)+"     "+rs.getInt(6)+"     "+rs.getInt(7)+"     "+rs.getInt(8)+"\n";
				while(rs.next()) {
					allDetails=allDetails+Main.size(rs.getString(1),20)+rs.getString(2)+"\t"+rs.getInt(3)+"     "+rs.getInt(4)+"     "+rs.getInt(5)+"     "+rs.getInt(6)+"     "+rs.getInt(7)+"     "+rs.getInt(8)+"\n";
				}
				MainFrame.status.setText("");
			} else {
				MainFrame.status.setForeground(Color.RED);
				MainFrame.status.setText(tmp+" details are Empty");
			}
			
		} catch(SQLException f) {
			MainFrame.status.setForeground(Color.RED);
			MainFrame.status.setText(f.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return allDetails;
	}
	
}
