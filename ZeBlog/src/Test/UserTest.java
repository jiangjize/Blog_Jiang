import cn.jjz.dao.UserDao;
import cn.jjz.entity.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.jms.Session;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/7/5.
 */
public class UserTest {


    @Test
    public void Login() throws Exception {
        String path="mybatis-config.xml";
        InputStream is= Resources.getResourceAsStream(path);
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=sf.openSession();
        UserDao dao=session.getMapper(UserDao.class);
       int l= dao.Login("lyblogscn1","111111");
       if(l>0){
           System.out.println("存在");
       }else{
           System.out.println("不存在");
       }
    }

    @Test
    public  void ListUser() throws Exception {
       String path="mybatis-config.xml";
        InputStream is= Resources.getResourceAsStream(path);
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=sf.openSession();
        UserDao dao=session.getMapper(UserDao.class);
        List<UserInfo> list= dao.ListUser();
        for (UserInfo u:list
             ) {
            System.out.println(u.getUserName()+u.getUserPwd());

        }
      //  session.close();
        System.out.println("++++++++++++++++++++++++++++++++");
        String path2="mybatis-config.xml";
        InputStream is2= Resources.getResourceAsStream(path2);
        SqlSessionFactory sf2=new SqlSessionFactoryBuilder().build(is2);
        SqlSession session2=sf2.openSession();
        UserDao dao2=session2.getMapper(UserDao.class);
        List<UserInfo> list2= dao2.ListUser();
        for (UserInfo u:list2
                ) {
            System.out.println(u.getUserName()+u.getUserPwd());
        }
    }
    @Test
    public void AddUser() throws Exception {
        String path="mybatis-config.xml";
        InputStream is= Resources.getResourceAsStream(path);
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=sf.openSession();
        UserDao dao=session.getMapper(UserDao.class);
        UserInfo userinfo=new UserInfo();
        userinfo.setUserName("jiangjiyuan");
        userinfo.setUserPwd("123456");
        userinfo.setLastLoginTime(new Date());
        int i=dao.AddUser(userinfo);
        if(i>0){
            System.out.println("yes");
            session.commit();
            System.out.println(userinfo.getUserCode());
        }
    }
}
