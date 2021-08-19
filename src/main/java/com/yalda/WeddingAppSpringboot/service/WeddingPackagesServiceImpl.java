package com.yalda.WeddingAppSpringboot.service;

import com.yalda.WeddingAppSpringboot.model.WeddingPackage;
import com.yalda.WeddingAppSpringboot.repository.WeddingPackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WeddingPackagesServiceImpl implements WeddingPackagesService {

    @Autowired
    private WeddingPackagesRepository weddingPackagesRepository;

    @Override
    public List<WeddingPackage> getAllWeddingPackages() {
        return weddingPackagesRepository.findAll();
    }
}
