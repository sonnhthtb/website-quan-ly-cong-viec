package org.sonptit.ToDo.entity;

import javax.persistence.*;

@Entity
@Table(name = "work")
public class WorkEntity extends BaseEntity{


    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private UserEntity user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
