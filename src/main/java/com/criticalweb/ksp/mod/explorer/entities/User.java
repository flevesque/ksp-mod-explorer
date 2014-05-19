package com.criticalweb.ksp.mod.explorer.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Francois Levesque on 5/18/14.
 */
@Entity
public class User {

    private Long id;

    private String username;
    private String password;
    private String email;
    private String displayName;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
}
