package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class exRequestFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset=\"UTF-8>\"");
	out.println("<title>サーブレット練習</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1>doGetが呼び出されました</h1>");
	out.println("</body>");
	out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String jender = request.getParameter("jender");
		String msg="";
		String errorMsg1="";
		String errorMsg2="";
		
		if(name == null || name.length() == 0) {
			errorMsg1 = "名前が未入力です";
		}
		if(jender == null || jender.length() == 0) {
			errorMsg2 = "性別が未選択です";
		}else {
			if(jender.equals("0")) {
				jender = "男性";
			}else {
				jender = "女性";
			}
		}
		msg = name + "さん（" + jender +"）を登録しました。";

		if(errorMsg1.length() != 0 || errorMsg2.length() != 0) {
			msg = errorMsg1 + "<br>" + errorMsg2;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8>\"");
		out.println("<title>サーブレット練習</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>doPostが呼び出されました</h1>");
		out.println("<p>" + msg + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
