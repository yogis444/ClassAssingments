import java.sql.*;
import java.util.*;
import java.io.*;
public class StoreImage 
{
Connection con;
public void openCon()throws Exception
{
Class.forName("oracle.jdbc.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@rama-pc:1521:xe","system","system");
System.out.println("connection is opened");
}
public void insert()throws Exception
{
Scanner s=new Scanner(System.in);
PreparedStatement pstmt=con.prepareStatement("insert into emp_info values(?,?,?)");
System.out.println("enter emp id");
int empid=s.nextInt();
pstmt.setInt(1,empid);
System.out.println("enter emp name");
String empname=s.next();
pstmt.setString(2,empname);
System.out.println("enter photo file path");
String path=s.next();

File f=new File("c:/pho001.gif");
int size=(int) f.length();
FileInputStream fis=new FileInputStream(f);
pstmt.setBinaryStream(3,fis,size);
int i=pstmt.executeUpdate();
System.out.println(i+"row inserted");
pstmt.close();
fis.close();
}
public void closeCon()throws Exception
{
con.close();
}

public static void main(String[] args)throws Exception 
{
 StoreImage p1= new StoreImage();
 p1.openCon();
 p1.insert();
 p1.closeCon();
 }
}