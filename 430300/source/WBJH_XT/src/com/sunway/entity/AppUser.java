package com.sunway.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="APP_USER")
public class AppUser implements Serializable {

    @Id
    private String username;
    @Column
    private String password;
    @Column
    private Integer enabled;
    @OneToMany(targetEntity=AppAuthority.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)	//一对多，让Employee维护外键
    @JoinColumn(name="username")
    private Set<AppAuthority> roles = new HashSet<AppAuthority>();

    public AppUser() {
        super();
    }

    public AppUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Set<AppAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppAuthority> roles) {
        this.roles = roles;
    }
}
