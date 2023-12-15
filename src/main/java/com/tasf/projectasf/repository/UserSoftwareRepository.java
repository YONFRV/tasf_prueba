/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.repository;

import com.tasf.projectasf.entity.UserSoftwareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FREDY
 */
@Repository
public interface UserSoftwareRepository extends JpaRepository<UserSoftwareEntity,Long> {
         UserSoftwareEntity findByUserSoftware(String userSoftware);
         UserSoftwareEntity findByKey(String key);
}
