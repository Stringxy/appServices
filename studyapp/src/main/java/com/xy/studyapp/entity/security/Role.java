package com.xy.studyapp.entity.security;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xy on 2017/6/23.
 */
//角色表
@Entity
@Table(name="t_role")
public class Role implements Serializable{
    @Id
    @Column (name="role_id",length=32)
    private String id;


    @Column(name="role_name",length=32)
    private String name;//角色名称

    private static final long serialVersionUID = 7541107130445748005L;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
