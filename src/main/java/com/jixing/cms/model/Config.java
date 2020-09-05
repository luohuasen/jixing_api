package com.jixing.cms.model;

import lombok.Data;

@Data
public class Config {
    private Integer id;

    private String type;

    private String key;

    private String value;

    private String description;
}