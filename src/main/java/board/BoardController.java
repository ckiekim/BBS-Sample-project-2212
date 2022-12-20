package board;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.BoardDao;

/**
 * Servlet implementation class BoardController
 */
@WebServlet({ "/board/list", "/board/search", "/board/write", "/board/update",
			  "/board/detail", "/board/delete", "/board/deleteConfirm" })
public class BoardController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		BoardDao dao = new BoardDao();
		//ReplyDao rdao = new ReplyDao();
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("uid");
		session.setAttribute("menu", "board");
		
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher rd = null;
		
		switch(action) {
		case "list":
			int page = Integer.parseInt(request.getParameter("page"));
			List<Board> list = dao.listUsers("title", "", page);
			
			session.setAttribute("currentBoardPage", page);
			int totalBoardNo = dao.getBoardCount();
			int totalPages = (int) Math.ceil(totalBoardNo / 10.);
			List<String> pageList = new ArrayList<>();
			for (int i = 1; i <= totalPages; i++)
				pageList.add(String.valueOf(i));
			request.setAttribute("pageList", pageList);
			
			String today = LocalDate.now().toString();		// 2022-12-20
			request.setAttribute("today", today);
			request.setAttribute("boardList", list);
			rd = request.getRequestDispatcher("/board/list.jsp");
			rd.forward(request, response);
			break;
		case "write":	
			if (request.getMethod().equals("GET")) {
				response.sendRedirect("/bbs/board/write.jsp");
			} else {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String files = request.getParameter("files");
				
				Board b = new Board(uid, title, content, files);
				dao.insert(b);
				response.sendRedirect("/bbs/board/list?page=1");
			}
			break;
			
			
			
		default:
			System.out.println(request.getMethod() + " 잘못된 경로");
		}
	}
	
}
