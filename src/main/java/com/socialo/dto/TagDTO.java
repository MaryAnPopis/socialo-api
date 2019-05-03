package com.socialo.dto;

import javax.persistence.*;


@Entity
@Table(name = "tags")
public class TagDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public TagDTO() {
    }
    public TagDTO( Long id , String name) {
        this.id = id;
        this.name = name;
    }

    public TagDTO(String name) {
        this.name = name;
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
