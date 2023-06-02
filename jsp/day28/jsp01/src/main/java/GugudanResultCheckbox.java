

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanResultCheckbox")
public class GugudanResultCheckbox extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GugudanResultCheckbox() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dan=Integer.parseInt(request.getParameter("dan"));
		String dans[]=request.getParameterValues("dan");
		/* getParameterValues는 String[]값을 반환하므로 String dans[]배열의 형태로 값을 받아야 함 */
//		System.out.println(dans[0]);
//		System.out.println(dans[1]);
//		System.out.println(dans[2]);
		
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
		
		for(String item:dans) {
			/* item:dans가 배열이므로 item을 int타입으로 변환한 뒤 그 값을 num이라는 변수에 대입 */
			//int num=Integer.parseInt(item);
			out.println("<h1>"+item+"단을 출력합니다.</h1>");
			for(int i=1;i<10;i++) {
				out.println("<p>"+item+"x"+i+"="+Integer.parseInt(item)*i+"</p>");
				/* 혹은 변수에 대입하지 않고 식에서 직접 Integer.parseInt(item)을 변환한 뒤 사용해도 가능 */
			}
		}
		
		out.println("<a href='javascript:history.back()'>뒤로 가기</a>");
		out.println("<a href='GugudanForm'>GogudanForm으로 돌아가기</a>");
		/* a태그를 입력한 뒤 javascript:histroy.back()을 걸어놓으면 뒤로 가게 만들 수 있음 */
		out.println("</body>");
		out.println("</html>");
	}

}
