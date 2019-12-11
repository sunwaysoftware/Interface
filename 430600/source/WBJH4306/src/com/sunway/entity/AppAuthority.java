package com.sunway.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_AUTHORITY")
public class AppAuthority implements Serializable {
	private static final long serialVersionUID = 4318268079272096056L;
	@Id
    @GenericGenerator(name = "appID", strategy = "uuid")
    @GeneratedValue(generator = "appID")
    private String id;
    @Column
    private String authority;
    @Column
    private String username;

    public AppAuthority() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
