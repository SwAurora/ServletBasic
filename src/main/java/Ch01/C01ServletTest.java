package Ch01;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/Servlet1.do")
public class C01ServletTest extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        System.out.println("init 함수 호출됨!");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        System.out.println("service 함수 호출됨!");
    }

    @Override
    public void destroy()
    {
        System.out.println("destroy 함수 호출됨!");
    }
}
