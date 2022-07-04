package Ch01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/C05Join.do")
public class C05GetPost extends HttpServlet
{
    String url = "jdbc:mysql://localhost:3306/jsptest";
    String id = "root";
    String pw = "1234";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public void init() throws ServletException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("Connected.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("Do get!");
        resp.sendRedirect("/05MemberJoin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        System.out.println("Do Post!");
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String addr1 = req.getParameter("addr1");
        String addr2 = req.getParameter("addr2");

        try
        {
            pstmt = conn.prepareStatement("insert into tmp_member values(?,?,?,?)");
            pstmt.setString(1, email);
            pstmt.setString(2, pwd);
            pstmt.setString(3, addr1);
            pstmt.setString(4, addr2);
            int result = pstmt.executeUpdate();
            if(result > 0)
            {
                System.out.println("Insert 성공");
                resp.sendRedirect("/05Login.jsp");
            }
            else
            {
                System.out.println("Insert 실패");
                resp.sendRedirect("/05MemberJoin.jsp");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy()
    {
        if(conn != null)
        {
            try
            {
                conn.close();
                System.out.println("Conn Closed.");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
