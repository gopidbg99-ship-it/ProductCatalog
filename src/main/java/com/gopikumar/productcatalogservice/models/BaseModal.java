package com.gopikumar.productcatalogservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseModal {
    private Long id;
    private Date createdAt;
    private Date lastUdatedAt;
    private State state;
}
