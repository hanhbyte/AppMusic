package com.demo.service;

import java.util.List;
import com.demo.model.Music;

public interface IMusicService {

  List<Music> findAll();

  void save(Music music);

  void delete(Long id);

  Music findById(Long id);
}
