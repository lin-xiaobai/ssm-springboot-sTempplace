package com.SimpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @date 2021/6/28 -12:24
 * 简单方式制作自定义标签SimpleTag
 * 最大的简化：将传统方式的doStartTag()  doEndTag() doafterBody()等方法 简化成一个通用的doTag方法，
 * doTag()：没有缓冲区，通过“流”进行操作
 * <p>
 * JspFragment中有一个invoke(Writer val1)方法（执行的意思），入参是“流”，即要修改显示内容，只需要修改此 流
 * invoke(Writer var1):每调用一次invoke()方法，会执行一次 标签体
 * SimpleTagSupport类中通过get可以获取 JspFragment对象
 */

/**
 * 案例：循环3次hello
 */
public class MySimpleTagIterator extends SimpleTagSupport {
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    //    核心方法
//    目的：
//    <aa>
//          xxx
//    </aa>
//把自定义标签体中的内容输出num次
    @Override
    public void doTag() throws JspException, IOException {
//        通过getJspBody方法获取JspFragment对象
//       getJspBody()获取标签
        JspFragment jspFragment = getJspBody();

        for (int i = 0; i < num; i++) {
            //通过invoke()执行标签体内容
// 入参是Write流，如果要将标签体的内容进行修改，
//需要修改先获取流，然后在流中修改
//不需要修改则传入null值
            jspFragment.invoke(null);
        }
    }
}
