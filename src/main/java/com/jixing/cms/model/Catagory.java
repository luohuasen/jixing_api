package com.jixing.cms.model;

import lombok.Data;

@Data
public class Catagory {
    private Integer id;

    private String catagoryName;

    private String catagoryDesc;

    private Integer displayOrder;
}