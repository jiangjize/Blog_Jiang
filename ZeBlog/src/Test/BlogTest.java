import cn.jjz.dao.BlogDao;
import cn.jjz.entity.BlogInfo;
import cn.jjz.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by lenovo on 2017/7/7.
 */
public class BlogTest {
    @Test
    public void list() throws Exception {
        SqlSession session=MyBatisUtil.getSqlSession();
        BlogDao dao=session.getMapper(BlogDao.class);
        List<BlogInfo> list=dao.ListUser();
        for (BlogInfo b:list
             ) {
            System.out.println(b.getBlogAddress()+b.getBlogAuthor()+b.getBlogPhoto());
        }
    }
    @Test
    public  void add() throws Exception {
        SqlSession session=MyBatisUtil.getSqlSession();
        BlogDao dao=session.getMapper(BlogDao.class);
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setBlogAddress("http://my.csdn.net/qq_36071065");
        blogInfo.setBlogAuthor("尹海龙");
        blogInfo.setBlogPhoto("7.jpg");
        int i=dao.AddUser(blogInfo);
        if(i>0){
            System.out.println("y");
            session.commit();
        }else{
            System.out.println("n");
        }
    }
    @Test
    public void del() throws Exception {
        SqlSession session=MyBatisUtil.getSqlSession();
        BlogDao dao=session.getMapper(BlogDao.class);
        dao.Del(24);
        session.commit();
    }
    @Test
    public void Up() throws Exception {
        SqlSession session=MyBatisUtil.getSqlSession();
        BlogDao dao=session.getMapper(BlogDao.class);
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setBlogId(1);
        blogInfo.setBlogAddress("http://my.csdn.net/qq_36074093");
        blogInfo.setBlogPhoto("7.png");
        blogInfo.setBlogAuthor("尹海龙");
       int i= dao.Up(blogInfo);
        if(i>0){
            System.out.println("y");
            session.commit();
        }else{
            System.out.println("n");
        }
    }
}
