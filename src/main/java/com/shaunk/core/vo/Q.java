package com.shaunk.core.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Project shaun
 * @Package com.shaun.api
 * @Name R
 * @Version 1.0
 * @Data: 2019/4/18 3:09 PM
 * @User: shaunk
 * @Description: API统一查询model
 */
@Data
public class Q implements Serializable {

    // 页码
    private int pageNo = 1;
    // 页数
    private int pageSize = 10;

}
