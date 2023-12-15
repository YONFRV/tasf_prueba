/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.tasf.projectasf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author FREDY
 */
@SpringBootApplication
@EntityScan({
        "com.tasf.projectasf.entity"
})

@EnableJpaRepositories({
        "com.tasf.projectasf.repository"
})
@ComponentScan(basePackages = {
        "com.tasf.projectasf.*"
})
public class ProjecTasf {

    public static void main(String[] args) {
        SpringApplication.run(ProjecTasf.class, args);
    }
}
