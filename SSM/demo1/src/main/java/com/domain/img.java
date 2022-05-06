package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @date 2021/10/26 -15:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class img implements Serializable {
    private int id;
    private String img;
    private String like;
}
