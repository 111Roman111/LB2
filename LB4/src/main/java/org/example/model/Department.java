package org.example.model;


import org.example.model.Group;

import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private List<Group> groups;

    public Department(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        org.example.model.Department that = (org.example.model.Department) o;
        return Objects.equals(name, that.name) && Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups);
    }
}
