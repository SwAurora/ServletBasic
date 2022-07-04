package Ch01;

import sw.servletbasic.HelloServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PostTest.do")
public class C03DoPostTest extends HelloServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("DoPost 함수 실행!");
        String userid = req.getParameter("userid");
        String pwd = req.getParameter("pwd");

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("USERID : " + userid + "<br>");
        out.println("PWD : " + pwd);
    }
}
