package com.jh.repositories;

import com.jh.domain.AlbumImage;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface AlbumImageRepository extends JpaRepository<AlbumImage, Long> {

}
