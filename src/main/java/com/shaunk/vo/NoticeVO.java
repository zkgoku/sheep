package com.shaunk.vo;

import com.shaunk.core.vo.Q;
import lombok.Data;

import java.util.Date;

/**
 * @Project sheep
 * @Package com.shaunk.vo
 * @Name QueryNoticeVO
 * @Version 1.0
 * @Data: 2019/7/5 1:50 PM
 * @Author: shaunk
 * @Description: TODO
 */
@Data
public class NoticeVO extends Q{

    private Integer id;

    private String title;

    private String content;

    private String contentHtml;

    private Integer status;

    private Integer userId;

    private Date createTime;

    private String nickName;

    private String avatar;

    private Integer action;
}
