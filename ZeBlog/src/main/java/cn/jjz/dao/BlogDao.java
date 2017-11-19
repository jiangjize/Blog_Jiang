package cn.jjz.dao;

import cn.jjz.entity.BlogInfo;
import cn.jjz.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2017/7/7.
 */
public interface BlogDao {
    //获取所有用户
    public List<BlogInfo> ListUser()throws Exception;
    //添加用户
    public int AddUser(BlogInfo blogInfo)throws Exception;
    //删除
    public int Del(@Param("id") int id)throws Exception;
    //修改
    public int Up(BlogInfo blogInfo)throws Exception;
}
