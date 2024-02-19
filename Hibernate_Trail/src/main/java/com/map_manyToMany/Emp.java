package com.map_manyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Emp {
    @Id
    private int eid ;
    private String name ;
    @ManyToMany
    @JoinTable(name = "emp_project",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects ;

    public Emp() {
    }

    public Emp(int eid, String name, List<Project> projects) {
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
