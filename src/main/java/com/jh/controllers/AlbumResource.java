package com.jh.controllers;

import com.jh.domain.Album;
import com.jh.services.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controllers for managing Album.
 */
@RestController
@RequestMapping("/api")
public class AlbumResource {

    private final Logger log = LoggerFactory.getLogger(AlbumResource.class);

    @Inject
    private AlbumService albumService;

    @RequestMapping(value = "/albums", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAlbum(
            @RequestBody
                    Album album) throws URISyntaxException {
        log.debug("REST request to save Album : {}", album);
        if (album.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }

        albumService.save(album);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public ResponseEntity<List<Album>> getAllAlbums(Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of Albums");

        Page<Album> page = albumService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @RequestMapping(value = "/albumsAsList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public List<Album> getAllAlbums() throws URISyntaxException {
        log.debug("REST request to get a page of Albums");

        List<Album> albumList = albumService.findAll();
        return albumList;
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Album> getAlbum(
            @PathVariable
                    Long id) {
        log.debug("REST request to get Album : {}", id);
        Album album = albumService.findOne(id);
        return Optional.ofNullable(album).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
