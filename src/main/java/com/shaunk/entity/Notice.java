package com.shaunk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;

/**
 * @Project sheep
 * @Package com.shaunk.entity
 * @Name Notice
 * @Version 1.0
 * @Data: 2019/7/5 11:32 AM
 * @Author: shaunk
 * @Description: TODO
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "system_notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "content_html")
    private String contentHtml;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_user_id")
    private Integer userId;

    @Column(name = "create_time")
    private Date createTime;


    @Transient
    private String nickName;

    public Notice(Integer id) {
        this.id = id;
    }
}
