package com.wxc.hwt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "UpdaServlet")//修改密码功能
public class UpdaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
//        session.setAttribute("pwd2",pwd2);

        String IDcard = (String) session.getAttribute("IDcard");
        if (pwd1.equals(pwd2)) {
            session.setAttribute("pwd2",pwd2);
            try {
//                String pwd=(String) session.getAttribute("pwd2");
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/bank";
                String username = "root";
                String password = "2016013924";
                Connection conn = DriverManager.getConnection(url, username, password);
//              Statement sql = conn.createStatement();
                String sql1 = "update user set pwd=? where IDcard=?";
                PreparedStatement ps = conn.prepareStatement(sql1);
                ps.setString(1, pwd2);
                // 对SQL语句中的第二个参数赋值
                ps.setString(2, IDcard);
                // 执行更新操作
                ps.executeUpdate();
                // 关闭PreparedStatement
                ps.close();
                // 关闭Connection
                conn.close();


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        response.sendRedirect("qsuccess.jsp");
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
