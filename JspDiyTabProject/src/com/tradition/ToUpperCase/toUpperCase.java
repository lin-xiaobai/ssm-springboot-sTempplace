package com.tradition.ToUpperCase;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * @date 2021/6/27 -19:00
 * <p>
 * bouTag接口：在标签体被显示之前，进行一些其他的“额外”的操作 ，例如将输入的结果转变成大写
 * 包含属性： int EVAL_BODY_BUFFERED=2,是daStartTag()的第三个返回值，代表一个缓冲区(BodyContent)
 * 如果返回值是EVAL_BODY_BUFFERED，则服务器会自动将标签体需要显示的内容放入缓冲区中（BodyContent）
 * <p>
 * 因此，如果要更改显示结果，只需要从 缓冲区 获取原来的数据 进行修改即可
 * <p>
 * 修改、缓冲区的方法：通过getXxx()获取原来的数据，自己修改为大写，输出 getEnclosingWriter();
 * <p>
 * <p>
 * 案例：在MyIteration类上的输出的hello转变成大写格式
 */

//步骤：
//    第一步：告诉程序，将原来的hello变成大写，即将doStartTag()的返回值设置为EVAL_BODY_BUFFERED(此步骤，以及默认在父类实现
//  第二步：获取，并且修改

public class toUpperCase extends BodyTagSupport {
//    继承BodyTagSupport就默认启动doStartTag()的方法
//    因为doStartTag()中的返回值以及固定为2（，即继续执行后面的代码），
//    所以将字符串转换为大写的方法就写在doEndTag()方法中
//    doStartTag()里的返回值为int EVAL_BODY_BUFFERED=2意思是重复执行JSP代码


    @Override
    public int doEndTag() throws JspException {
        //获取h缓冲区getBodyContent()
        //获取缓冲区的内容：getBodyContent().getString()
//        案例中：hello
        try {
//        MyIteration content=new MyIteration();
//        int num= content.getNum();

            String content = getBodyContent().getString();
            //       将content中的内容修改成大写格式
            content = content.toUpperCase();
            //        输出
            bodyContent.getEnclosingWriter().write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

//   默认6，代表标签执行完毕后，是否执行其他的JSP元素
        return super.doEndTag();
    }
}
