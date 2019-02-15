package com.maciej.ppmtool.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date stat_date;
    private Date end_date;
    private Date created_at;
    private Date updated_at;

    public Project() {
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }


}
