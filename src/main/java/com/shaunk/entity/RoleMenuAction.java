package com.shaunk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Project shaun
 * @Package com.shaun.model
 * @Name RoleMenu
 * @Version 1.0
 * @Data: 2019/5/13 7:47 PM
 * @User: shaunk
 * @Description: TODO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "system_role_menu_action")
public class RoleMenuAction implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "action_id")
    private Integer actionId;

    public RoleMenuAction(Integer roleId, Integer actionId) {
        this.roleId = roleId;
        this.actionId = actionId;
    }
}
