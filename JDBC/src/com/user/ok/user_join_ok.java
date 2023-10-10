package com.user.ok;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user_join_ok")
public class user_join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public user_join_ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Form으로 돌아온 값 처리 (post)
	      request.setCharacterEncoding("utf-8"); //인코딩
	      
	      String id = request.getParameter("id");
	      String pw = request.getParameter("pw");
	      String name = request.getParameter("name");
	      String phone1 = request.getParameter("phone1");
	      String phone2 = request.getParameter("phone2");
	      String gender = request.getParameter("gender");
	      //검증
	      System.out.println(id + " ," + pw + " ," + name+ " ," + phone1+ " ," + phone2+ " ," + gender);
	      //DB와 연동에 필요한 변수를 선언
	      String url="jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul";
	      String driver = "com.mysql.cj.jdbc.Driver";
	}

}
