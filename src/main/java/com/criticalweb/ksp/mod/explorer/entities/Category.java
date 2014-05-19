package com.criticalweb.ksp.mod.explorer.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Francois Levesque on 5/18/14.
 */
@Entity
public class Category {

	private Long id;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Project.class)
	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}
}
