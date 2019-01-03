package com.wxc.hwt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "detailServlet")//实现查询余额功能
public class detailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
//        double qmoney=Double.parseDouble(request.getParameter("qmoney"));//获取输入金额
        String IDcard = (String) session.getAttribute("IDcard");//获取银行卡号
//        session.setAttribute("qmoney",qmoney);//金额存入服务器
//        String money="你输入的余额不足";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bank";
            String username = "root";
            String password = "2016013924";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("select *from operate where IDcard='" + IDcard + "'");
            ArrayList<Operate> list = new ArrayList<Operate>();
            while (rs.next()) {
                Operate operate=new Operate(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4));
                list.add(operate);

            }
            request.setAttribute("list",list);
            rs.close();		// 关闭ResultSet
            conn.close();	// 关闭Connection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        request.getRequestDispatcher("/showdetail.jsp").forward(request,response);

    }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
