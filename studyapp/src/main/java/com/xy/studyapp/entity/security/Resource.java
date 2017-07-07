package com.xy.studyapp.entity.security;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by xy on 2017/6/26.
 */
@Entity
@Table(name="t_resource")
public class Resource implements Serializable{
    private static final long serialVersionUID = -7830086693569999528L;
    @Id
    @Column(name="resource_id",length=32)
    private String id;
    @Column(name="resource_url",length=32)
    private String url;
    @Column(name="name",length=32)
    private String name;

    public Resource() {
        this.id = UUID.randomUUID().toString().replace("-","");;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
