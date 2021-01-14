package com.gmail.deamon999.repositories;

import java.util.List;

import com.gmail.deamon999.entities.Singer;

public interface SingerDao {
    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer contact);

    void delete(Singer contact);
}
