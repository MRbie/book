package com.bie.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 数据交互层dao层
 * @author Administrator
 *
 */
public class BaseDao {

	private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql:///book";
    private static String user="root";
    private static String password="123456";
    
    /***
     * 连接数据库的方法
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getCon() throws ClassNotFoundException, SQLException{
    	//加载数据库驱动
    	Class.forName(driver);
        System.out.println("测试加载数据库成功");
        //数据库连接操作
        Connection con=DriverManager.getConnection(url, user, password);
        System.out.println("测试数据库链接成功");
        return con;
    }
    
    /***
     * 关闭数据库的方法
     * @param con
     * @param ps
     * @param rs
     */
    public static void close(Connection con,PreparedStatement ps,ResultSet rs){
        if(rs!=null){//关闭资源，避免出现异常
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /***
     * 统一增删改的方法
     * @param sql
     * @param arr
     * @return
     */
    public static boolean addUpdateDelete(String sql,Object[] arr){
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=BaseDao.getCon();//第一步 ：连接数据库的操作
            ps=con.prepareStatement(sql);//第二步：预编译
            //第三步：设置值
            if(arr!=null && arr.length!=0){
                for(int i=0;i<arr.length;i++){
                    ps.setObject(i+1, arr[i]);
                }
            }
            int count=ps.executeUpdate();//第四步：执行sql语句
            if(count>0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
        try {
            BaseDao.getCon();
            System.out.println("测试数据库链接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
