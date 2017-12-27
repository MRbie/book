package com.bie.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/***
 * 1.1：写DbUtils的工具类
 * :utils是工具类，方便以后调用
 * 在main方法测试的时候出现一个错误，
 * 瞄了一眼立马想到了没有添加mysql的驱动，
 * 所以我感觉测试还是很有必要的
 * @author biehongli
 *
 */
public class DbUtils {

	private static String drivername;//数据库驱动，为了加载数据库驱动
	private static String url;//数据库连接字符串，只要是找到自己的数据库，需要和自己的数据库一致
	private static String user;//数据库账号，需要和自己的一致
	private static String password;//数据库密码，需要和自己的一致
	
	static{
		drivername=ResourceBundle.getBundle("db").getString("drivername");
		url=ResourceBundle.getBundle("db").getString("url");
		user=ResourceBundle.getBundle("db").getString("user");
		password=ResourceBundle.getBundle("db").getString("password");
	}
	
	/***
	 * 加载数据库驱动和连接到数据库，我一般是加载和连接的时候分别输出，可以快速找到哪里出错
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() throws Exception{
		Class.forName(drivername);//记载数据库驱动
		System.out.println("测试加载数据库驱动");
		//连接到数据库
		Connection con=DriverManager.getConnection(url, user, password);
		System.out.println("测试连接到数据库");
		return con;
	}
	
	/***
	 * 这个用来判断关闭数据库的方法
	 * @param con 关闭Connection的连接
	 * @param ps  关闭PreparedStatement
	 * @param rs  关闭ResultSet
	 */
	public static void getClose(Connection con,PreparedStatement ps,ResultSet rs){
		//关闭数据库，注意关闭的顺序。养成好习惯
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/***
	 * 添加(插入)和更新(更改)可以提取公共的方法写在工具类中
	 * 删除一般使用伪删除，这样删除就是更新(更改)操作，
	 * 所以只有查询(查找)需要写更多的代码
	 * @param sql 外面传来的sql语句
	 * @param arr 外面传来的数组类型的，是用户信息封装到集合传递进来
	 * @return 返回的是一个整形的数据类型
	 */
	public static int addAndUpdate(String sql,Object[] arr){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=DbUtils.getCon();//第一步连接数据库
			ps=con.prepareStatement(sql);//第二步预编译
			//第三步给sql语句中的参数复制
			for(int i=0;i<arr.length;i++){
				ps.setObject(i+1, arr[i]);
			}
			//第四步执行sql并且返回。
			return ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源，如果没有ResultSet类型的，加上null即可
			DbUtils.getClose(con, ps, null);
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		//我一般在写好连接数据库的工具类时先测试一下，避免连接数据库都失败，测试后可注释即可
		try {
			DbUtils.getCon();
			System.out.println("测试连接数据库终极版！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
