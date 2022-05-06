package CET4Web.Servlet;

import CET4Web.Bean.CET4Bean;
import CET4Web.IService.IService;
import CET4Web.ServiceImpl.ServiceImpl;
import org.apache.jasper.tagplugins.jstl.core.Out;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @date 2021/7/6 -0:31
 */
@WebServlet("/add")
public class CET4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        String phone = req.getParameter("phone");
        String pwd = req.getParameter("upwd");
        String name = req.getParameter("user");
        String uid = req.getParameter("uid");
        String checkcode = req.getParameter("checkcode");

//        获取验证码真实值

        char c[] = pwd.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 'Q');//将明文转换成密文
        }
        String npwd = new String(c, 0, c.length);

        System.out.println(npwd);

        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 'Q');//将密文还原为明文
        }
        String string1 = new String(c, 0, c.length);
        System.out.println("明文：" + string1);


        CET4Bean cet4 = new CET4Bean(phone, npwd, name, uid);
        IService etc = new ServiceImpl();
        boolean flag = etc.addetc(cet4);
        PrintWriter out = resp.getWriter();


        if (flag == true) {
            out.println(name + "报名成功");
        } else {
            out.println(name + "报名失败");
        }
    }


}
