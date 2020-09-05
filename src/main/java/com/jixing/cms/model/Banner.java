package com.jixing.cms.model;

import lombok.Data;

@Data
public class Banner {
    private Integer id;

    private String image;

    private String description;

    private Integer displayOrder;
}