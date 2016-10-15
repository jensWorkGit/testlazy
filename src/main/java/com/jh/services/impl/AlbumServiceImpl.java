package com.jh.services.impl;

import com.jh.domain.Album;
import com.jh.domain.AlbumImage;
import com.jh.repositories.AlbumRepository;
import com.jh.services.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    private final Logger log = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Inject
    private AlbumRepository albumRepository;

    public Album save(Album album) {
        log.debug("Request to save Album : {}", album);

        for (AlbumImage albumImage : album.getAlbumImages()) {
            albumImage.setCreationDate(new Date());
            albumImage.setAlbum(album);
        }

        Album result = albumRepository.save(album);
        return result;
    }

    @Transactional(readOnly = true)
    public Page<Album> findAll(Pageable pageable) {
        log.debug("Request to get all Albums");
        Page<Album> result = albumRepository.findAll(pageable);

        return result;
    }

    @Transactional(readOnly = true)
    public List<Album> findAll() {
        log.debug("Request to get all Albums");
        List<Album> result = albumRepository.findAll();

        return result;
    }

    @Transactional(readOnly = true)
    public Album findOne(Long id) {
        log.debug("Request to get Album : {}", id);
        Album album = albumRepository.findOne(id);
        return album;
    }

    public void delete(Long id) {
        log.debug("Request to delete Album : {}", id);
        albumRepository.delete(id);
    }
}
