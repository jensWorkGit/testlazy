package com.jh.repositories;

import com.jh.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
