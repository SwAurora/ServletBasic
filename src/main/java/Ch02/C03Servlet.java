package Ch02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Join.do")
public class C03Servlet extends HttpServlet
{
    // URL : /Join.do
    // doGet()으로 /WEB-INF/03MemberJoin.jsp로 forward
    // 03Memberjoin.jsp에는 파라미터 email, pwd, addr1, addr2의 값을 입력해서
    // 다시 /Join.do로 post방식으로 전달
    // 서블릿에서는 doPost()로 파라미터를 전부 받아서 콘솔창에 출력한 뒤
    // 03Result.jsp로 forward
    // 03Result.jsp에서는 받은 파라미터를 브라우저 화면에 출력

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/WEB-INF/03MemberJoin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String addr1 = req.getParameter("addr1");
        String addr2 = req.getParameter("addr2");

        System.out.println(email + ", " + pwd + ", " + addr1 + ", " + addr2);

        req.getRequestDispatcher("/WEB-INF/03Result.jsp").forward(req,resp);
    }
}
