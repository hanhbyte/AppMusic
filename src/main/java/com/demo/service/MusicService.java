package com.demo.service;

import java.util.List;
import com.demo.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.repository.IMusicRepository;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {

  @Autowired
  IMusicRepository musicRepository;

  @Override
  public List<Music> findAll() {
    return musicRepository.findAll();
  }

  @Override
  public void save(Music music) {
    musicRepository.save(music);
  }

  @Override
  public void delete(Long id) {
    musicRepository.delete(id);
  }

  @Override
  public Music findById(Long id) {
    return musicRepository.findById(id);
  }
}
