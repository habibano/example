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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardPath = "";
		String action = null;

		request.setCharacterEncoding("UTF-8");
		action = request.getParameter("action");
		
		//初回呼び出し時
		if(action == null) {
			forwardPath = "/WebContent/registerForm.jsp";
		}

		//ユーザ登録時
		else if(action.equals("done")) {
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		
			//セッションインスタンスからユーザ情報を取得
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			//ユーザ登録処理
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(user);

			//セッションインスタンスの破棄
			session.removeAttribute("user");
			
		}else{
			//拡張用
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストされたユーザ情報を元にインスタンス生成
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		User user = new User(id, password, name);
		
		//セッションインスタンス生成、ユーザ情報の一時保存
		HttpSession session = request.getSession();
		session.setAttribute("user",user);
		
		//ユーザ登録の確認画面へ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
