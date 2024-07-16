package servlet;

import java.io.IOException;

import beans.Questionnaire;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.QuestionnaireCnt;

/**
 * 自己紹介ページのリクエストに対応するサーブレット
 * リクエスト元：HiroakiSite.jsp
 */
public class HiroakiSiteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = null;
		action = request.getParameter("action");

		String forwardPath="/WEB-INF/jsp/HiroakiSiteResult.jsp";
		
		//アプリケーションスコープ（コンテキスト）の取得
		ServletContext applicaiton = this.getServletContext();

		//アンケートインスタンスを生成
		Questionnaire questionnaire = new Questionnaire();
		
		//アンケートのカウント加算ロジック呼出のためのインスタンスを生成
		QuestionnaireCnt qc = new QuestionnaireCnt();
		
		//リクエストパラメータに応じて加算メソッドを呼び出し
		if(action == null) {
			forwardPath="/WebContent/HiroakiSite.jsp";
		}else if(action.equals("dog")) {
			qc.excuteDogCnt(questionnaire);
		}else if(action.equals("cat")) {
			qc.excuteCatCnt(questionnaire);
		}else {
			//拡張用
		}
		
		//コンテキストへ保存
		applicaiton.setAttribute("questionnaire", questionnaire);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
		
	}

}
