package com.user.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user_modify_ok")
public class User_modify_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public User_modify_ok() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보수정 페이지로 이동하기 위한 DB에서 정보를 얻어오는 작업
		// DB에서 가져올 정보는 session에서 id값을 얻어서 사용
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		//DAO 객체 호출
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getInfo(id);
		//강제 저장
		request.setAttribute("user_vo", vo);
		RequestDispatcher dp =request.getRequestDispatcher("user_update.jsp");
		dp.forward(request, response);
		
		// DB연동을 위한 변수 및 객체 선언
//		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String user = "mytest";
//		String password = "mytest";
//				
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		//SQL
//		String sql = "select * from testuser where id = ?";
//		
//		MemberDAO dao = MemberDAO.getInstance();
//		
//		dao.join(dao.getInfo(id));
//		int result = dao.update(id);
//		session.setAttribute("M", dao.getInfo(id));
//		dao.join(vo);
		
		
	}
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			/*
//			 * rs.next() 결과값 조회
//			 * rs.getString(컬럼명)을 통해 값을 얻어옴 name, phone1, phone2, gender
//			 * request로 강제 저장 후 forward update.jsp전달
//			 */
//			if(rs.next()) {
//				String name = rs.getString("name");
//				String pw = rs.getString("pw");
//				String phone1 = rs.getString("phone1");
//				String phone2 = rs.getString("phone2");
//				String gender = rs.getString("gender");
				//request에 강제 저장 및 포워드
//				request.setAttribute("user_name", name);
//				request.setAttribute("user_pw", pw);
//				request.setAttribute("user_phone1", phone1);
//				request.setAttribute("user_phone2", phone2);
//				request.setAttribute("user_gender", gender);
//				
//				System.out.println(name + ", " + pw + ", " + phone1 + ", " + phone2 + ", " + gender);
//			}
//			
//			RequestDispatcher rd = request.getRequestDispatcher("user_update.jsp");
//			rd.forward(request, response);
//	
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			Jdbc
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
