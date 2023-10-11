package com.casestudy.case_study.model;

public class EducationDegree {
    private Long id;
    private String name;

    public EducationDegree(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EducationDegree() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
