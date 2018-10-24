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
 * Servlet implementation class jougou
 */
@WebServlet("/jougou")
public class jougou extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public jougou() {
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
		request.setAttribute("selectlist", Selectlist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userjouhou.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
