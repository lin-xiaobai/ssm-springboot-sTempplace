package com.tradition.MyIteration;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @date 2021/6/26 -18:06
 * 自定义标签
 * 1.先编写标签处理类
 * 2.编写标签描述符
 * 3.导入并使用
 * <p>
 * 编写标签处理类：传统方式（JSP1.1)
 * 主要方法：doStartTag()
 * 案例分析：先执行一次hello，并重复两次
 * <xxx>hello</xxx>
 * <p>
 * doStartTag()方法执行完毕后执行doAfterBody()方法
 */

//需要继承TageSupport类
public class MyIteration extends TagSupport {
    private int num;//执行次数：3

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    //    执行标签
    @Override
//    标签处理类的核心方法
//    该方法的返回值0或者1
//   常量：SKIP_BODY=0;标签体不会被执行
// 常量：EVAL_BODY_INCLUDE=1标签会被执行
    public int doStartTag() throws JspException {
//        EVAL_BODY_INCLUDE是一个常量值
//        表示标签会被执行，先执行一次

        return EVAL_BODY_INCLUDE;
    }
//    执行完毕之后的方法
//    当标签体执行完毕之后的操作，通过返回值决定
//    例如可以让  标签在执行完毕后，再执行一次
//    常量：EVAL_BODY_AGAIN=2; 重复执行
//    常量：SKIP_BODY=0;不再执行

    @Override
    public int doAfterBody() throws JspException {
        num--;
        //重复执行
//        判断结果是否大于0；如果是则继续执行，如果小于0则结束
//        EVAL_BODY_AGAIN=2; 重复执行
//        SKIP_BODY表示不再执行标签体
        return num > 0 ? EVAL_BODY_AGAIN : SKIP_BODY;
    }

}
