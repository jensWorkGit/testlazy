package com.jh.controllers;

import com.jh.domain.AlbumImage;
import com.jh.services.AlbumImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlbumImageResource {

    private final Logger log = LoggerFactory.getLogger(AlbumImageResource.class);

    @Inject
    private AlbumImageService albumImageService;

    @RequestMapping(value = "/album-images", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAlbumImage(
            @Valid
            @RequestBody
                    AlbumImage albumImage) throws URISyntaxException {
        log.debug("REST request to save AlbumImage : {}", albumImage);
        if (albumImage.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        albumImageService.save(albumImage);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/album-images", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumImage>> getAllAlbumImages(Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of AlbumImages");
        Page<AlbumImage> page = albumImageService.findAll(pageable);


        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @RequestMapping(value = "/album-images/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumImage> getAlbumImage(
            @PathVariable
                    Long id) {
        log.debug("REST request to get AlbumImage : {}", id);
        AlbumImage albumImage = albumImageService.findOne(id);
        return Optional.ofNullable(albumImage).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
