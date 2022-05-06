package com.spring5.extractBean;

import java.util.List;

/**
 * @date 2021/7/14 -18:20
 * 提取spring配置文件中list集合类型中的属性
 */
public class book {
    private List<book> bookName;

    public void setBookName(List<book> bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
