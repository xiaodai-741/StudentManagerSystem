package StudentManagerSystem.Servlet;


import StudentManagerSystem.DAO.ManagerDAO1;
import StudentManagerSystem.vo.Manager;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static StudentManagerSystem.DAO.ManagerDAO1.findAll;
import static StudentManagerSystem.DAO.ManagerDAO1.managerLogin;


public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        String mid = request.getParameter("mid");
        String psw = request.getParameter("psw");
        PrintWriter out = response.getWriter();
//        if(mid.equals("1001")&&psw.equals("admin")){
//            List<Manager> mlist = findAll();
//            out.print(mlist.toString());
//            for(Manager man : mlist){
//                out.print(man.toString());
//            }

//        }
//    }
        List<Manager> M = managerLogin(mid, psw);
        if (M.size()>0) {
            response.sendRedirect("ManagerIndex.jsp");
        } else {
            JOptionPane.showMessageDialog(null,"账号或密码错误");
            response.sendRedirect("index.jsp");
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
