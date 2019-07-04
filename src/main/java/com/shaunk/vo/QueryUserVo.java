package com.shaunk.vo;


import com.shaunk.core.vo.Q;
import lombok.Data;

/**
 * @Project sheep
 * @Package com.shaunk.vo
 * @Name QueryUserVo
 * @Version 1.0
 * @Data: 2019/6/29 11:23 AM
 * @User: shaunk
 * @Description: TODO
 */
@Data
public class QueryUserVo extends Q{


    private String phone;

    private Integer status;

    private String nickName;

    private String email;


}
