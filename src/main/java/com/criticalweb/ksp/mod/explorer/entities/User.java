package com.criticalweb.ksp.mod.explorer.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@Entity
public class User {

    private Long id;

    private String username;
    private String password;
	private String salt;
    private String email;
    private String displayname;
	private boolean active;
	private String activationkey;

    private Collection<Project> projects;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", targetEntity = Project.class)
    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getActivationkey() {
		return activationkey;
	}

	public void setActivationkey(String activationkey) {
		this.activationkey = activationkey;
	}
}
