package com.jixing.cms.model;

import lombok.Data;

@Data
public class LeaveWord {
    private Integer id;

    private String username;

    private String phone;

    private String email;

    private String qq;

    private String companyName;

    private String gmtCreate;

    private String gmtModified;

    private String body;

}