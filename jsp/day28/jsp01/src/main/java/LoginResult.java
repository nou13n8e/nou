

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginResult")
public class LoginResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* doGet일 때는 주소창에 내가 request하는 내용이 노출, doPost일 때는 주소창에 내가 request하는 내용이 노출되지 않음 */
		/* get / post / service(get+post)에 따라 처리 방식이 바뀌므로 주의할 것! */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		if(userId.equals("nou") && userPw.equals("1234")) {
			out.println("<p>로그인 성공</p>");
		}else {
			out.println("<p>로그인 실패</p>");
			out.println("<a href='javascript:history.back()'>뒤로 가기</a>");
			/* 실패했을 때만 "뒤로 가기"가 출력 */
		}
		
		
	}

}
