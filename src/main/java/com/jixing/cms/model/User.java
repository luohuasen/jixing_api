package com.jixing.cms.model;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String avatar;

    private String nickname;
}