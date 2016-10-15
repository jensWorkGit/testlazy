package com.jh.services;

import com.jh.domain.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlbumService {

    Album save(Album album);


    Page<Album> findAll(Pageable pageable);

    List<Album> findAll();

    Album findOne(Long id);
}
