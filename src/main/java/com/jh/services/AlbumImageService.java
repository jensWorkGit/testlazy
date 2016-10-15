package com.jh.services;

import com.jh.domain.AlbumImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbumImageService {

    AlbumImage save(AlbumImage albumImage);

    Page<AlbumImage> findAll(Pageable pageable);

    AlbumImage findOne(Long id);
}
