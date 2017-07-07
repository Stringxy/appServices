package com.xy.studyapp.entity.other;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 首页banner
 * Created by xy on 2017/7/7.
 */
@Entity
@Table(name = "t_banner")
public class Banner implements Serializable {
    private static final long serialVersionUID = 8787919374271702090L;
    @Id
    @Column(name="banner_id",length=32)
    private String id;
    @Column(name="url",length=255)
    private String url;
    @Column(name="banner_src",length=255)
    private String src;

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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
