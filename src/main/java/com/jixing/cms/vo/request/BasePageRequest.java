package com.jixing.cms.vo.request;

import lombok.Data;

@Data
public class BasePageRequest {
    private Integer pageIndex = 0;
    private Integer pageSize = 0;
}
