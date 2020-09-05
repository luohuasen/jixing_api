package com.jixing.cms.vo.response;

import lombok.Data;

import java.util.List;

@Data
public class BasePageResponse {
    private String code = "0";
    private String message;
    private List list;
    private Integer sum = 0;
    private Integer pageSum = 0;

    public static BasePageResponse success(List list, Integer sum, Integer pageSum){
        BasePageResponse response = new BasePageResponse();
        response.setList(list);
        response.setPageSum(pageSum);
        response.setSum(sum);
        return response;
    }

    public static BasePageResponse fail(String message){
        BasePageResponse response = new BasePageResponse();
        response.setMessage(message);
        return response;
    }
}
