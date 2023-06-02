

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanForm")
public class GugudanForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GugudanForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/* 한글로 입력해도 값을 출력할 수 있도록 설정 */
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='GugudanResult'><input type='text' name='dan'><button>구구단 출력 부탁드립니다.</button></form>");
		/* form태그, button태그를 순서대로 입력한 뒤 form태그에 GugudanResult를 걸어놓으면 값을 입력한 순간 주소창에서 Form이 Result로 바뀜 */
		out.println("</body>");
		out.println("</html>");
	}

}
