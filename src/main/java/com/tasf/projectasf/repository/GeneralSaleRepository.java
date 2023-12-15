/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tasf.projectasf.repository;

import com.tasf.projectasf.entity.GeneralSaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author FREDY
 */
public interface GeneralSaleRepository extends JpaRepository<GeneralSaleEntity,Long >{
             GeneralSaleEntity findByConsecutiveSaleId(long consecutiveSaleId);
}
