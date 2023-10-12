package com.user.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user_login_ok")
public class User_login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public User_login_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Form 태그로 로그인 정보 전달
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		System.out.println(id+": "+pw); 검증했으니 주석
		// DB 접속을 위해 필요한 변수 및 객체
//		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String user = "mytest";
//		String password = "mytest";
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		// SQL
//		String sql = "select * from testuser where id = ? and pw =?";
//			
//		try {
//			//1. Driver 로드
//			Class.forName(driver);
//			//2. Connection 객체 생성
//			conn = DriverManager.getConnection(url, user, password);
//			//3. pstmt 객체
//			pstmt = conn.prepareStatement(sql);
//			//4. sql 실행
//			pstmt.setString(1, id);
//			pstmt.setString(2, pw);
//			//5. ResultSet 객체에 응답 내용을 담음
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) { // id, pw가 일치하는 경우, 로그인 sql로 얻은 정보를 통해 session 생성
//				HttpSession session = request.getSession(); // 세션 객체 생성
//				session.setAttribute("user_id", id); // 세션 객체에 user_id 생성해서 id넣기
//				//로그인시 보여줄 페이지로 전환
//				response.sendRedirect("user_mypage.jsp");
//				} else {
//					//실패
//					response.sendRedirect("user_login_fail.jsp");				}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//				if(rs != null) rs.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		//MemberDAO 객체
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.login(id, pw);
		if(result ==1) {
			HttpSession session = request.getSession(); // 세션 객체 생성
			session.setAttribute("user_id", id); // 세션 객체에 user_id 생성해서 id넣기
			response.sendRedirect("user_mypage.jsp");
		}else {
			response.sendRedirect("user_login_fail.jsp");
		}
	}
}
