package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.USER;

/**
 * Servlet implementation class sinki
 */
@WebServlet("/sinki")
public class sinki extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sinki() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession();
		if(ses.getAttribute("userInfo")==null) {
			response.sendRedirect("login");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_sinki.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String birthDate = request.getParameter("birthDate");
		String Password = request.getParameter("Password");
		String Passwordc = request.getParameter("Passwordc");
		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		UserDao userdao=new UserDao();
		USER user= userdao.CheckByLoginId(login_id);
		if(login_id.equals("")||Password.equals("")||name.equals("")||birthDate.equals("")||user!=null) {
			request.setAttribute("Mserr","入力された内容は正しくありません。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_sinki.jsp");
			dispatcher.forward(request, response);
			return ;
		}else if(!Password.equals(Passwordc)) {

			request.setAttribute("checkerr","パスワードが正しくありません。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_sinki.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		userdao.cruser(login_id, Password, name, birthDate);

		response.sendRedirect("top");
	}

}
