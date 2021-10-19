package com.demo.repository;

import java.util.List;
import com.demo.model.Music;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository {
  List<Music> findAll();
  void save(Music music);
  void delete(Long id);
  Music findById(Long id);
}
