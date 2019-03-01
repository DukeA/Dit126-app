package com.webbapp.webapp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "app_users", schema = "public", catalog = "dit126")
public class AppUsersEntity {
    private int userId;
    private String userPassword;
    private String userName;
    private Collection<ActivityEntity> activitiesByUserId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUsersEntity that = (AppUsersEntity) o;

        if (userId != that.userId) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "appUsersByUserId")
    public Collection<ActivityEntity> getActivitiesByUserId() {
        return activitiesByUserId;
    }

    public void setActivitiesByUserId(Collection<ActivityEntity> activitiesByUserId) {
        this.activitiesByUserId = activitiesByUserId;
    }
}
