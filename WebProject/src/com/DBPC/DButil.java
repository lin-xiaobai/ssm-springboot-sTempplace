package com.DBPC;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DButil {

    static {
//		注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement creatPreparedStatement(String sql, Object[] obj) throws SQLException {
        PreparedStatement ps = null;
        Connection con = null;


//		使用连接池连接数据库
//		将访问数据库的连接 指向“数据源”
//		获取tomcat中conf/context.xml配置文件
        try {
            Context ctx = new InitialContext(); //获取context.xml配置文件
            //context.xml配置文件中name为studnet的数据源，通过Type类型找到
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/student");
//			连接数据源，指向数据源
            con = ds.getConnection();
            System.out.println("....");
        } catch (NamingException e) {
            e.printStackTrace();
        }


        ps = con.prepareStatement(sql);
        if (obj != null) {
//			循环遍历object里面的类型
            for (int i = 0; i < obj.length; i++) {
//				因为object的下标是从0开始的，但是sql语句中问好是从1开始的
                ps.setObject(i + 1, obj[i]);
            }
        }
        return ps;
    }

    //获取数据库的总条数
    public static int getTotalCount(String sql) {
        int count = -1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = creatPreparedStatement(sql, null);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnector.close(DBConnector.con, ps, rs);
        }
        return count;

    }

    //通用的增删改
    //传参是sql语句和一个obj对象（object对象里面可以放万能的类型（例如string类型和int类型等）
    public static boolean excute(String sql, Object[] obj) {
        boolean flag = false;
        int count = -1;
        PreparedStatement pstmt = null;
        try {
////				为问号赋值
//				pstmt=DBConnector.open().prepareStatement(sql);//预编译sql语句
////				判断obj是否为空
//				if(obj!=null){
////					循环遍历object里面的类型
//					for(int i=0;i<obj.length;i++){
////						因为object的下标是从0开始的，但是sql语句中问好是从1开始的
//						pstmt.setObject(i+1,obj[i]);
//					}
//				}
            count = creatPreparedStatement(sql, obj).executeUpdate();

            if (count > 0)
                flag = true;
            else
                flag = false;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
//				因为增删改里面没有结果集，所以为他赋上个null值
            DBConnector.close(DBConnector.con, pstmt, null);
        }
        return flag;

    }

    //通用的查
    public static ResultSet excuteQuery(String sql, Object[] obj) {
        ResultSet rs = null;
        try {
            rs = creatPreparedStatement(sql, obj).executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
//					这个最后不能关闭数据库close方法
        return rs;
    }


//		public static void main(String[] args) throws SQLException {
//			DButil dButil=new DButil();
//			ShopBean sBean=new ShopBean();
//			添加数据
//			String sql="insert into shop_news (id,s_code,s_name,s_price,s_place) values (null,?,?,?,?)";
//			sBean.setScode("112");
//			sBean.setSname("校园");
//			sBean.setSprice(120);
//			sBean.setSplace("广东");
//			Object[] obj={sBean.getScode(),sBean.getSname(),sBean.getSprice(),sBean.getSplace()};
//			boolean result=DButil.excute(sql, obj);
//			System.out.println(result);
    //			删除数据
//			String sql="delete from shop_news where s_code=?";
//			String code="111";
//			Object[] obj={code};
//			改数据
//			String sql="update shop_news set s_code=?,s_name=?,s_price=?,s_place=? where s_code=?";
//			String oldCode="1";
//			sBean.setScode("25");
//			sBean.setSname("校园");
//			sBean.setSprice(120);
//			sBean.setSplace("广东");
//			Object[] obj={sBean.getScode(),sBean.getSname(),sBean.getSprice(),sBean.getSplace(),oldCode};
//			boolean result=DButil.excute(sql, obj);
//			System.out.println(result);
    //查数据
//			ShopBean sBean=null;
//			String sql="select * from shop_news where s_code=?";
//			String s_code="25";
//			Object[] obj={s_code};
//			ResultSet rs=DButil.excuteQuery(sql, obj);
//			if(rs.next()){
//				int id=rs.getInt("id");
//				String code=rs.getString("s_code");
//				String name=rs.getString("s_name");
//				double price=rs.getDouble("s_price");
//				String place=rs.getString("s_place");
//			sBean=new ShopBean(id,code,name,price,place);
//		}
//			DBConnector.close(DBConnector.con, DBConnector.stmt, rs);
//			System.out.println(sBean);
////			
////		}
//		}

}
