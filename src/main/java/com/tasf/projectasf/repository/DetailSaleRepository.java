/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tasf.projectasf.repository;

import com.tasf.projectasf.entity.DetailSaleEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author FREDY
 */
public interface DetailSaleRepository extends JpaRepository<DetailSaleEntity,Long >{
          List<DetailSaleEntity> findByNumberSale(long numberSale);
}
