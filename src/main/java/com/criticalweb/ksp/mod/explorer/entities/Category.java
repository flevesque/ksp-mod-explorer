package com.criticalweb.ksp.mod.explorer.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@Entity
public class Category {

	private Long id;
	private String displayname;
	private Collection<Project> projects;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Project.class)
	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}
}
