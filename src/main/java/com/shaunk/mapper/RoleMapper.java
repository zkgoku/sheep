package com.shaunk.mapper;



import com.shaunk.entity.Role;
import com.shaunk.vo.QueryRoleVo;
import com.shaunk.vo.RoleVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    /**
     *
     * @param queryRoleVo
     * @return
     */
    List<RoleVo> listRole(QueryRoleVo queryRoleVo);

    /**
     * xx
     * @param id
     * @return RoleVo
     */
    RoleVo selectRoleById(Integer id);

    List<String> selectRoleMenu(Integer roleId);


}
