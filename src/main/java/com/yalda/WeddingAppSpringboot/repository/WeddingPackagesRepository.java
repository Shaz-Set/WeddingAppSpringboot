package com.yalda.WeddingAppSpringboot.repository;

import com.yalda.WeddingAppSpringboot.model.WeddingPackage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WeddingPackagesRepository extends JpaRepository<WeddingPackage,Long> {
}
