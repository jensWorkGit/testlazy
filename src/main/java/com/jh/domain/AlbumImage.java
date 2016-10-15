package com.jh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A AlbumImage.
 */
@Entity
@Table(name = "album_image")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AlbumImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "base_64_encoded_image")
    @Lob
    private String base64EncodedImage;

    @Column(name = "base_64_encoded_preview_image")
    @Lob
    private String base64EncodedPreviewImage;

    @Column(name = "creation_date")
    @JsonIgnore
    private Date creationDate;

    @ManyToOne
    @JsonIgnore
    private Album album;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase64EncodedImage() {
        return base64EncodedImage;
    }

    public void setBase64EncodedImage(String base64EncodedImage) {
        this.base64EncodedImage = base64EncodedImage;
    }

    public String getBase64EncodedPreviewImage() {
        return base64EncodedPreviewImage;
    }

    public void setBase64EncodedPreviewImage(String base64EncodedPreviewImage) {
        this.base64EncodedPreviewImage = base64EncodedPreviewImage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlbumImage albumImage = (AlbumImage) o;
        if (albumImage.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, albumImage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AlbumImage{" + "id=" + id + ", base64EncodedImage='" + base64EncodedImage + "'" +
               ", base64EncodedPreviewImage='" + base64EncodedPreviewImage + "'" + ", creationDate='" + creationDate +
               "'" + '}';
    }
}
