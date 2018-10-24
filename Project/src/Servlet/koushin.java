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
 * Servlet implementation class koushin
 */
@WebServlet("/koushin")
public class koushin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public koushin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession();

		if(ses.getAttribute("userInfo")==null) {
			response.sendRedirect("login");
			return;
		}
		String id = request.getParameter("id");
		UserDao usdao= new UserDao();
		USER Selectlist = usdao.findSelect(id);
		ses.setAttribute("selectlist", Selectlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userkousin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String Password = request.getParameter("Password");
		String Passwordc = request.getParameter("Passwordc");
		UserDao userdao=new UserDao();

		if(birthDate.equals("")||name.equals("")) {
			request.setAttribute("Mserr","入力された内容は正しくありません。" );
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userkousin.jsp");
			dispatcher.forward(request, response);
			return ;
		}

		if(!Password.equals(Passwordc)) {
			request.setAttribute("checkerr","パスワードが正しくありません。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userkousin.jsp");
			dispatcher.forward(request, response);
			return ;
		}

		if(Password.equals("")) {
			userdao.NoPassUp(name, birthDate, id);

		}else {

		userdao.PassUp(Password, name, birthDate, id);
		}
		response.sendRedirect("top");

	}
}
