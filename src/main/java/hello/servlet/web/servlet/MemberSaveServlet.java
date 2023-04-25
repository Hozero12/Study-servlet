package hello.servlet.web.servlet;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet" , urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = memberRepository.save(new Member(username, age));

        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        PrintWriter w = res.getWriter();
        w.write("<html> \n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body> \n" +
                "성공" +
                "<ul>\n" +
                "<li>id = "+member.getId()+"</li>\n" +
                "<li>username = "+member.getUsername()+"</li>\n" +
                "<li>age = "+member.getAge()+"</li>" +
                "</ul>\n" +
                "<a href=\"/index.htmL\">메인</a>\n" +
                "</body>\n" +
                "</html>");
    }
}
