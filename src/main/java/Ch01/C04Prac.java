package Ch01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MemberJoin.do")
public class C04Prac extends HttpServlet
{
    //서블릿 파일 만들기(URL : /MemberJoin.do)
    //doPost함수 오버라이딩
    //form으로 부터 요청이 들어오면 해당 파라미터를 브라우저로 전송
    //form에서 전송하는 내용은 userid, email, addr1, addr2
    //03form.jsp를 만들어서 진행

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String userid = req.getParameter("userid");
        String email = req.getParameter("email");
        String addr1 = req.getParameter("addr1");
        String addr2 = req.getParameter("addr2");

        PrintWriter out = resp.getWriter();
        out.println("아이디 : " + userid + "<br>");
        out.println("이메일 : " + email + "<br>");
        out.println("주소 : " + addr1 + "<br>");
        out.println("상세주소 : " + addr2);
    }
}
