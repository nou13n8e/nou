

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Hello() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		/* 3 name의 값으로 한글을 넣어도 처리 가능 */
		String name="";
		name=request.getParameter("name");
		/* 2 서버로부터 받은 name(/Hello?name=nou)의 값을 request(요청)한 값을 getParameter로 처리하여 name에 대입 */
		
		int num01=0;
		int num02=0;
		/* 5 선언을 해두었어도 값이 String 타입으로 넘어오기 때문에 Integer.parseInt처리를 할 수 없어서 에러 발생 */
		num01=Integer.parseInt(request.getParameter("num01"));
		num02=Integer.parseInt(request.getParameter("num02"));
		int sum=num01+num02;
		/* 4 request한 값을 받을 때는 무조건 String 타입이므로 Integer.parseInt로 처리하여 int로 변환 */
		
		PrintWriter out=response.getWriter();
		/* 1 printWriter를 import한 뒤 response(응답)할 값을 getWriter로 처리하여 출력 */
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+name+" hello servlet</h1>");
		out.println("<h1>"+num01+"+"+num02+"="+sum+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
