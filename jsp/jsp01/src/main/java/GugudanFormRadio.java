

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanFormRadio")
public class GugudanFormRadio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GugudanFormRadio() {
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
				+ "<label><span>1단</span><input type='radio' name='dan' value='1'></label>"
				+ "<label><span>2단</span><input type='radio' name='dan' value='2'></label>"
				+ "<label><span>3단</span><input type='radio' name='dan' value='3'></label>"
				+ "<label><span>4단</span><input type='radio' name='dan' value='4'></label>"
				+ "<label><span>5단</span><input type='radio' name='dan' value='5'></label>"
				+ "<label><span>6단</span><input type='radio' name='dan' value='6'></label>"
				+ "<label><span>7단</span><input type='radio' name='dan' value='7'></label>"
				+ "<label><span>8단</span><input type='radio' name='dan' value='8'></label>"
				+ "<label><span>9단</span><input type='radio' name='dan' value='9'></label>"
				/* name='dan'뒤에 아무것도 적지 않으면 name=on으로 넘어가므로 value에 값을 넣어줘야만 정상적으로 처리 가능 */
				+ "<button>구구단 출력 부탁드립니다.</button></form>");
		out.println("</body>");
		out.println("</html>");
	}

}
