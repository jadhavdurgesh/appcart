package com.durgesh.appcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.appcart.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
