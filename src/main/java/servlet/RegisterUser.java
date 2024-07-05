package servlet;

import java.io.IOException;

import beans.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.RegisterUserLogic;

/**
 * ユーザ登録もどきサーブレット
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ユーザ登録画面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "";
		}
		
		if(action.equals("done")) {
			
			//Sessionスコープからユーザ情報を取得
			HttpSession session = request.getSession();//これ毎回必要なのか？
			User user = (User)session.getAttribute("user");
			
			//ユーザ登録処理
			RegisterUserLogic regUserLogic = new RegisterUserLogic();
			regUserLogic.execute(user);
			
			//ユーザ登録完了画面をフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerDone.jsp");
			dispatcher.forward(request, response);
			
		}else{//action="back"を想定
			//ユーザ登録画面をフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WebContent/registerForm.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * ユーザ登録確認画面
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ユーザインスタンスに基本情報を保存
		User user = new User();
		request.setCharacterEncoding("UTF-8");
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		
		//セッションスコープにユーザインスタンスを保存
		HttpSession session = request.getSession();
		session.setAttribute("user",user);
		
		//ユーザ登録画面をフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
