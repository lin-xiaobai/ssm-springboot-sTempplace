package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import java.io.Serializable;

/**
 * @date 2021/10/23 -16:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int uid;
    private String name;
    private String password;
    private String telephone;
    private String slat;

}
