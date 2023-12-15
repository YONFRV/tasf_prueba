package com.tasf.projectasf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author FREDY
 */
@Entity
@Table(name = "user_software")
@Data
public class UserSoftwareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    private String userSoftware;
    private String password;
    private String key;
    private int state;
}
