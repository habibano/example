package servlet;

import java.io.IOException;

import beans.Health;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.HealthCheckLogic;

/**
 * 健康診断　身長、体重を受け取りBMIを計算し結果を返すサーブレット
 */
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WebContent/HealthCheck.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエスト情報取得
		request.setCharacterEncoding("UTF-8");
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		//exHealthインスタンス生成、リクエストスコープに保存
		Health health = new Health(height,weight);
		request.setAttribute("health", health);

		//モデルを担うjavaクラスのインスタンスを生成し、BMI計算メソッドを呼び出す
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
		healthCheckLogic.excute(health);
		
		//Viewへディスパッチャー
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/HealthCheckResult.jsp");
		dispatcher.forward(request, response);
	}

}
