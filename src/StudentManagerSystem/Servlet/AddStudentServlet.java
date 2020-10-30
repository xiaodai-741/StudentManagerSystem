package StudentManagerSystem.Servlet;

import StudentManagerSystem.DAO.StudentDAO;
import StudentManagerSystem.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;


@WebServlet(name = "AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String StudentNO = request.getParameter("stuNO");
        String SName = request.getParameter("SName");
        String Sex = request.getParameter("Sex");
        String Age = request.getParameter("Age");
        String SPassWord = request.getParameter("SPassWord");
        int SNO = Integer.parseInt(StudentNO);
        int sAge = Integer.parseInt(Age);
        Student stu = new Student(SNO, SName, Sex, sAge, SPassWord);
        int i = StudentDAO.save(stu);
        if (i >= 0) {
            response.sendRedirect("ManagerIndex.jsp");
            JOptionPane.showMessageDialog(null, "添加成功");
        } else {
            response.sendRedirect("addStudent.jsp");
            JOptionPane.showMessageDialog(null, "添加失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
