package com.jh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Album.
 */
@Entity
@Table(name = "album")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "base_64_encoded_album_image")
    @Lob
    private String base64EncodedAlbumImage;

    @Column(name = "creation_date")
    @JsonIgnore
    private Date creationDate;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AlbumImage> albumImages = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBase64EncodedAlbumImage() {
        return base64EncodedAlbumImage;
    }

    public void setBase64EncodedAlbumImage(String base64EncodedAlbumImage) {
        this.base64EncodedAlbumImage = base64EncodedAlbumImage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<AlbumImage> getAlbumImages() {
        return albumImages;
    }

    public void setAlbumImages(Set<AlbumImage> albumImages) {
        this.albumImages = albumImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Album album = (Album) o;
        if (album.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", name='" + name + "'" + ", description='" + description + "'" +
               ", base64EncodedAlbumImage='" + base64EncodedAlbumImage + "'" + ", creationDate='" + creationDate + "'" +
               '}';
    }
}
