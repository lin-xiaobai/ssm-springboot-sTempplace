package myservlet;

import com.DBPC.DButil;

import java.io.IOException;

/**
 * @date 2021/6/14 -18:06
 */
@javax.servlet.annotation.WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("dapostsssssss");
        //测试tomcat中的dbcp数据源
        String sql = "delete from shop_news where id=?";
        Object[] params = new Object[]{70};
        boolean falg = DButil.excute(sql, params);
        System.out.println(falg);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("dagetssssssssssssssssssssssss");
        this.doPost(request, response);
    }
}
