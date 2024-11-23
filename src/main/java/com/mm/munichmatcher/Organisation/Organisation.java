package com.mm.munichmatcher.Organisation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Organisation {

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
