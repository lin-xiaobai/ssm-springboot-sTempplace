package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @date 2021/10/21 -19:47
 */
@Data       //get、set等方法
@AllArgsConstructor     //有参构造
@NoArgsConstructor      //无参构造
public class Book implements Serializable {
        private Integer bookId;
        private String bookName;
        private Integer bookCounts;
        private String detail;
}
