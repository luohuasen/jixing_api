package com.jixing.cms.model;

import lombok.Data;

@Data
public class SubCatagory {
    private Integer id;

    private Integer catagoryId;

    private String subCatagoryName;

    private String subCatagoryDesc;

    private Integer displayOrder;
}