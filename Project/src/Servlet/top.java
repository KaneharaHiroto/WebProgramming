package Servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class top
 */
@WebServlet("/top")
public class top extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public top() {
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
		UserDao usdao= new UserDao();
		List<USER> uslist = usdao.findAll();
		request.setAttribute("userList", uslist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_top.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String login_id = request.getParameter("login_id");
		String name =request.getParameter("name");
		String rowdate = request.getParameter("rowdate");
		String highdate = request.getParameter("highdate");
		UserDao userdao=new UserDao();
		List<USER> uslist= userdao.search(login_id, name, rowdate, highdate);
		request.setAttribute("userList", uslist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_top.jsp");
		dispatcher.forward(request, response);


	}
}
