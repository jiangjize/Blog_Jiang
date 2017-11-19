package cn.jjz.servlet;

import cn.jjz.dao.UserDao;
import cn.jjz.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/7/5.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String act= request.getParameter("act");
       request.setCharacterEncoding("UTF-8");
        if(act!=null){
            if(act.equals("Login")){

                try {
                    System.out.println("登陆");
                    SqlSession session= MyBatisUtil.getSqlSession();
                    UserDao dao=session.getMapper(UserDao.class);
                    String id=request.getParameter("username");
                    request.setAttribute("name",id);
                    request.getSession().setAttribute("name",id);
                    String pwd=request.getParameter("password");
                     int  f= dao.Login(id,pwd);
                     if(f>0){

                         request.getRequestDispatcher("html/main.jsp").forward(request,response);
                     }else{
                         request.getRequestDispatcher("html/index.jsp").forward(request,response);
                     }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    request.getRequestDispatcher("html/index.jsp").forward(request,response);
                }
            }else if(act.equals("UnLogin")){
                System.out.println("注销");
                request.getSession().removeAttribute("name");
                request.getRequestDispatcher("html/index.jsp").forward(request,response);
            }
        }else{
            request.getRequestDispatcher("html/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
