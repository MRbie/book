package com.bie.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bie.po.UserInfo;
import com.bie.system.dao.UserInfoDao;
import com.bie.utils.BaseDao;

/***
 * 用户信息的操作的dao层实现类
 * @author Administrator
 *
 */
public class UserInfoDaoImpl implements UserInfoDao{

	@Override
	public UserInfo login(UserInfo user) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="select * from user_info where user_account=? and user_pw=? ";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setString(1, user.getUserAccount());
            ps.setString(2, user.getUserPw());
            rs=ps.executeQuery();//5:执行sql语句
            UserInfo users=null;
            if(rs.next()){
                users=new UserInfo();
                //从数据库中获取值设置到实体类的setter方法中
                users.setUserId(rs.getInt("user_id"));
                users.setUserAccount(rs.getString("user_account"));
                users.setUserPw(rs.getString("user_pw"));
                users.setUserNumber(rs.getString("user_number"));
                users.setUserName(rs.getString("user_name"));
                users.setUserAge(rs.getInt("user_age"));
                users.setUserSex(rs.getString("user_sex"));
                users.setUserMark(rs.getString("user_mark"));
                return users;
            }else{
                return null;
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭资源，避免出现异常
            BaseDao.close(con, ps, rs);
        }
        return null;
	}

	@Override
	public List<UserInfo> selectUser(String sql, Object[] arr) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=BaseDao.getCon();//第一步连接数据库
			ps=con.prepareStatement(sql);//第二步：预编译
			if(arr!=null){
				for(int i=0;i<arr.length;i++){
					ps.setObject(i+1, arr[i]);
				}
			}
			//第四步执行sql
			rs=ps.executeQuery();
			List<UserInfo> list=new ArrayList<UserInfo>();
			while(rs.next()){
				UserInfo users=new UserInfo();
				users.setUserId(rs.getInt("user_id"));
                users.setUserAccount(rs.getString("user_account"));
                users.setUserPw(rs.getString("user_pw"));
                users.setUserNumber(rs.getString("user_number"));
                users.setUserName(rs.getString("user_name"));
                users.setUserAge(rs.getInt("user_age"));
                users.setUserSex(rs.getString("user_sex"));
                users.setUserMark(rs.getString("user_mark"));
				
				//测试数据
				//System.out.println(user);
				list.add(users);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭资源，避免出现异常
			BaseDao.close(con, ps, rs);
		}
		
		return null;
	}

	@Override
	public UserInfo getUserId(Integer userId) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="select * from user_info where user_id=? ";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setInt(1, userId);
            rs=ps.executeQuery();//5:执行sql语句
            UserInfo users=null;
            if(rs.next()){
                users=new UserInfo();
                //从数据库中获取值设置到实体类的setter方法中
                users.setUserId(rs.getInt("user_id"));
                users.setUserAccount(rs.getString("user_account"));
                users.setUserPw(rs.getString("user_pw"));
                users.setUserNumber(rs.getString("user_number"));
                users.setUserName(rs.getString("user_name"));
                users.setUserAge(rs.getInt("user_age"));
                users.setUserSex(rs.getString("user_sex"));
                users.setUserMark(rs.getString("user_mark"));
                return users;
            }else{
                return null;
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭资源，避免出现异常
            BaseDao.close(con, ps, rs);
        }
        return null;
	}

	
	
	
}
