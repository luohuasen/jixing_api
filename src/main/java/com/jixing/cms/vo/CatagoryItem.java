package com.jixing.cms.vo;

import com.jixing.cms.model.Catagory;
import com.jixing.cms.model.SubCatagory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CatagoryItem extends Catagory {
    private List<SubCatagory> subList = new ArrayList<>();

    public void addSubCataGory(SubCatagory subCatagory){
        subList.add(subCatagory);
    }
}
