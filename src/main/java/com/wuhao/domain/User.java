package com.wuhao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: User 实体类
 * @author: wuhao
 * @create: 2020-06-19 11:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String username;

    private String birthday;

    private String sex;

    private String address;

}
