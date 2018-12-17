package com.github.lyd.rbac.producer.service;

import com.github.lyd.rbac.client.entity.ResourcePermission;

import java.util.List;

/**
 * 资源授权
 *
 * @author liuyadu
 */
public interface PermissionService {

    /**
     * 获取租户已授权资源(包含个人特殊权限和所拥有角色的所以权限)
     *
     * @param tenantId       租户ID
     * @param resourceType 资源类型
     * @return
     */
    List<ResourcePermission> getTenantPermission(Long tenantId, String resourceType);

    /**
     * 获取租户授权列表
     *
     * @param tenantId
     * @return
     */
    List<ResourcePermission> getTenantPrivatePermission(Long tenantId);

    /**
     * 获取所有授权列表
     *
     * @return
     */
    List<ResourcePermission> getPermissionList();

    /**
     * 添加授权
     *
     * @param identityId      所有者ID
     * @param identityPrefix    所有者类型:user-租户 role-角色
     * @param resourceType 资源类型:
     * @param resourceIds
     * @return
     */
    boolean addPermission(Long identityId, String identityPrefix, String resourceType, Long... resourceIds);

    /**
     * 更新授权信息
     * 支持更新name,url,resourcePid,serviceId
     * 不允许修改权限标识
     *
     * @param resourceType
     * @param resourceId
     * @return
     */
    boolean updatePermission(String resourceType, Long resourceId);

    /**
     * 检查资源是否存在
     *
     * @param resourceId
     * @param resourceType
     * @return
     */
    boolean isExist(Long resourceId, String resourceType);
}
