

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanResult")
public class GugudanResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GugudanResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dan=Integer.parseInt(request.getParameter("dan"));
		response.setContentType("text/html;charset=utf-8");
		/* request(요청) / response(응답) 흐름 차이를 주의할 것! */
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+dan+"단을 출력합니다.</h1>");
		for(int i=1;i<10;i++) {
			out.println("<p>"+dan+"x"+i+"="+dan*i+"</p>");
		}
		out.println("<a href='javascript:history.back()'>뒤로 가기</a>");
		out.println("<a href='GugudanForm'>GogudanForm으로 돌아가기</a>");
		/* a태그를 입력한 뒤 javascript:histroy.back()을 걸어놓으면 뒤로 가게 만들 수 있음 */
		out.println("</body>");
		out.println("</html>");
	}

}
