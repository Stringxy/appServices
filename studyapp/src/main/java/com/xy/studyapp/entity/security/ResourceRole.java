package com.xy.studyapp.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by xy on 2017/6/26.
 */
@Entity
@Table(name="t_resource_role")
public class ResourceRole implements Serializable{

    private static final long serialVersionUID = 5518081481348796482L;
    @Id
    @Column(name="id",length=32)
    private String id;
    @Column(name="resource_id",length=32)
    private String resourceId;
    @Column(name="role_id",length=32)
    private String roleId;

    @Override
    public String toString() {
        return "ResourceRole{" +
                "id='" + id + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
