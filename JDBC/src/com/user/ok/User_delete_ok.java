package com.user.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user_delete_ok")
public class User_delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public User_delete_ok() { }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * sql - delete from testuser where id = ?;
		 * String name = request.getParameter("name");
		 *  1. id는 세션에서 얻는다
		 *  2. pstmt를 이용해서 삭제
		 *  3. executeUpdate() 메서드 실행 후 반환 값 확인
		 *  	1 -> 성공. 세션 전부 삭제 후 user_login.jsp로 이동
		 *  	0 -> 실패. user_mypage.jsp로 이동
		 */
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		//Dao
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.delete(id);
		
		if(result ==1) {
			session.invalidate();
			response.sendRedirect("user_login.jsp");
		} else if(result ==0) {
			response.sendRedirect("user_mypage.jsp");
		}
//		request.setCharacterEncoding("utf-8");
//		
//		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String user = "mytest";
//		String pw = "mytest";
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		String sql = "delete from testuser where id = ?";
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, pw);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			int result = pstmt.executeUpdate();
//			if(result ==1) {
//				session.invalidate();
//				response.sendRedirect("user_login.jsp");
//			} else if(result ==0) {
//				response.sendRedirect("user_mypage.jsp");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn!=null) conn.close();
//				if(pstmt!=null) pstmt.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
