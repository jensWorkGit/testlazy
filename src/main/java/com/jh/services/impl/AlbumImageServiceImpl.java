package com.jh.services.impl;

import com.jh.domain.AlbumImage;
import com.jh.repositories.AlbumImageRepository;
import com.jh.services.AlbumImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class AlbumImageServiceImpl implements AlbumImageService {

    private final Logger log = LoggerFactory.getLogger(AlbumImageServiceImpl.class);

    @Inject
    private AlbumImageRepository albumImageRepository;

    public AlbumImage save(AlbumImage albumImage) {
        log.debug("Request to save AlbumImage : {}", albumImage);
        AlbumImage result = albumImageRepository.save(albumImage);
        return result;
    }

    @Transactional(readOnly = true)
    public Page<AlbumImage> findAll(Pageable pageable) {
        log.debug("Request to get all AlbumImages");
        Page<AlbumImage> result = albumImageRepository.findAll(pageable);
        return result;
    }

    @Transactional(readOnly = true)
    public AlbumImage findOne(Long id) {
        log.debug("Request to get AlbumImage : {}", id);
        AlbumImage albumImage = albumImageRepository.findOne(id);
        return albumImage;
    }

    public void delete(Long id) {
        log.debug("Request to delete AlbumImage : {}", id);
        albumImageRepository.delete(id);
    }
}
