package com.webbapp.webapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "app_users", schema = "public", catalog = "dit126")
public class AppUsersEntity {
    @Id
    @SequenceGenerator(name="app_users_user_id_seq", sequenceName="app_users_user_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="app_users_user_id_seq")
    @NotNull
    @Column(name = "user_id", updatable=false)
    private Integer userId;

    @Basic
    @Column(name = "user_password")
    @Getter
    @Setter
    private String userPassword;

    @Basic
    @Column(name = "user_name")
    @Getter
    @Setter
    private String userName;

    @OneToMany(mappedBy = "appUsersByUserId")
    @Getter
    @Setter
    private Collection<ActivityEntity> activitiesByUserId;



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
}
