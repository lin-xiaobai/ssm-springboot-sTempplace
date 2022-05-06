package CET4Web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @date 2021/7/5 -23:54
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean falg = false;
        //        获取用户输入的验证码
//        在前端中使用ajax的方法
//        将从键盘获取的信息保存ajax中的key和value中
        String checkcodeClient = req.getParameter("checkcode");

//        获取真实的验证码值
//        在img.jsp中将正确的验证码放在session域中
//        在servlet中不能直接获取session，需要从request中获取
        String checkCodeServer = (String) req.getSession().getAttribute("checkCode");
//    判断键盘上输入的验证码是否为真
        if (checkcodeClient.equals(checkCodeServer)) {
            falg = true;
//          request.getSession().setAttribute("falg",falg);
        } else {
            falg = false;
//          request.getSession().setAttribute("falg",falg);
        }
//      判断是否输入验证码
        System.out.println(falg);
        resp.setContentType("text/html;charset=UTF-8");
        Writer out = resp.getWriter();
        out.write(falg + " ");

//     关闭流
        out.flush();
        out.close();

    }
}
