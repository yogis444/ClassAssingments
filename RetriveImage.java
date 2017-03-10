import java.sql.*;
import java.util.*;
import java.io.*;
public class RetriveImage 
{
Connection con;
public void openCon()throws Exception
{
Class.forName("oracle.jdbc.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@rama-pc:1521:xe","system","system");
System.out.println("connection is opened");
}
public void select()throws Exception
{
Scanner s=new Scanner(System.in);
PreparedStatement pstmt=con.prepareStatement("select photo from emp_info where empid=?");
System.out.println("enter emp id");
int empid=s.nextInt();
pstmt.setInt(1,empid);
ResultSet rs=pstmt.executeQuery();
rs.next();
InputStream is=rs.getBinaryStream(1);
rs.close();
FileOutputStream fos=new FileOutputStream("c:/img001.gif");
int k;
while((k=is.read())!=-1)
{
fos.write(k);
}
System.out.println("picture is ready open c:drive");
pstmt.close();
fos.close();
}//end of
public void closeCon()throws Exception
{
con.close();
}//end of select

public static void main(String[] args)throws Exception 
{
RetriveImage ps= new RetriveImage();
ps.openCon();
ps.select();
ps.closeCon();
 }//end of main
}//end of class