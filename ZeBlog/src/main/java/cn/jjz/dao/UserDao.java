package cn.jjz.dao;

import cn.jjz.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2017/7/5.
 */
public interface UserDao {
    //登陆
    public int Login(@Param("userName") String  uname, @Param("userPwd") String pwd)throws Exception;
    //获取所有用户
    public List<UserInfo> ListUser()throws Exception;
    //添加用户
    public int AddUser(UserInfo userInfo)throws Exception;
}
