package cn.jjz.servlet;

import cn.jjz.dao.BlogDao;
import cn.jjz.entity.BlogInfo;
import cn.jjz.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2017/7/7.
 */
public class BlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String act=request.getParameter("act");
        SqlSession session=MyBatisUtil.getSqlSession();
        BlogDao dao=session.getMapper(BlogDao.class);
        if(act!=null){
            if(act.equals("add")){
                BlogInfo blogInfo=new BlogInfo();
                try {
                    String ad=request.getParameter("address");
                    String au= request.getParameter("author");
                    String ph= request.getParameter("photo");
                    blogInfo.setBlogAuthor(au);
                    blogInfo.setBlogAddress(ad);
                    blogInfo.setBlogPhoto(ph);
                    int i= dao.AddUser(blogInfo);
                    session.commit();
                    if(i>0){
                        List<BlogInfo> list=dao.ListUser();
                        request.setAttribute("bloglist",list);
                        request.getRequestDispatcher("html/bloglist.jsp").forward(request,response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(act.equals("upinfo")){   //点击修改后进入该方法
                //拿到用户点击的博客信息的数据  并放入request作用域
                String ad=request.getParameter("address");
                String ph=request.getParameter("photo");
               String au=request.getParameter("author");
               int id=Integer.parseInt(request.getParameter("id"));
                 request.setAttribute("ad",ad);
                request.setAttribute("au",au);
                request.setAttribute("id",id);
                request.setAttribute("ph",ph);
                //转入编辑页面
                request.getRequestDispatcher("html/uplist.jsp").forward(request,response);

            }else if(act.equals("up")){
           BlogInfo b=new BlogInfo();
                try {
                    b.setBlogAddress(request.getParameter("address"));
                    b.setBlogPhoto(request.getParameter("photo"));
                    b.setBlogAuthor(request.getParameter("author"));
                    b.setBlogId(Integer.parseInt(request.getParameter("id")));
                   int i= dao.Up(b);
                    session.commit();
                   if(i>0){
                       List<BlogInfo> list=dao.ListUser();
                       request.setAttribute("bloglist",list);
                       System.out.println("yes");

                       request.getRequestDispatcher("html/bloglist.jsp").forward(request,response);
                   }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(act.equals("del")){
              int id=Integer.parseInt(request.getParameter("id"));
                try {
                    int i=dao.Del(id);
                    session.commit();
                    if(i>0){

                            List<BlogInfo> list=dao.ListUser();
                            request.setAttribute("bloglist",list);
                            request.getRequestDispatcher("html/bloglist.jsp").forward(request,response);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            //进入博客列表
            try {
                List<BlogInfo> list=dao.ListUser();
                request.setAttribute("bloglist",list);
                request.getRequestDispatcher("html/bloglist.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
