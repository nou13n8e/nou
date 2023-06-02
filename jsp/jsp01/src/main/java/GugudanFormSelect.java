

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanFormSelect")
public class GugudanFormSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GugudanFormSelect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='GugudanResult'>"
				/* form태그, button태그를 순서대로 입력한 뒤 form태그에 GugudanResult를 걸어놓으면 값을 입력한 순간 주소창에서 Form이 Result로 바뀜 */
				+ "<select name='dan'>"
				+ "<option value='1'>1</option>"
				+ "<option value='2'>2</option>"
				+ "<option value='3'>3</option>"
				+ "<option value='4'>4</option>"
				+ "<option value='5'>5</option>"
				+ "<option value='6'>6</option>"
				+ "<option value='7'>7</option>"
				+ "<option value='8'>8</option>"
				+ "<option value='9'>9</option>"
				+ "</select>"
				+ "<button>구구단 출력 부탁드립니다.</button></form>");
		out.println("</body>");
		out.println("</html>");
	}

}
