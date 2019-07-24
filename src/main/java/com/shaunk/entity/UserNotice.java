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
public class UserNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "notice_id")
    private Integer noticeId;

    @Column(name = "if_read")
    private Integer ifRead;


}
