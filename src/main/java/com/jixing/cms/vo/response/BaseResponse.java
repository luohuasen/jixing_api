package com.jixing.cms.vo.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class BaseResponse {
    private String code = "0";
    private String message;
    private Object data;

    public static BaseResponse success(Object data){
        BaseResponse response = new BaseResponse();
        response.setData(data);
        return  response;
    }

    public static BaseResponse fail(String message){
        BaseResponse response = new BaseResponse();
        response.setMessage(message);
        return response;
    }
}
