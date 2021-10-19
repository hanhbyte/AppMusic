package com.demo.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.demo.model.Music;
import org.springframework.stereotype.Repository;

@Repository
public class MusicRepository implements IMusicRepository {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public List<Music> findAll() {
    String query = "select m from Music as m";
    List<Music> musicList = entityManager.createQuery(query, Music.class).getResultList();
    return musicList;
  }

  @Override
  public void save(Music music) {
    if (music != null){
      entityManager.merge(music);
    }else {
      entityManager.persist(music);
    }
  }

  @Override
  public void delete(Long id) {
    Music music = findById(id);
    if (music != null){
      entityManager.remove(id);
    }
  }

  @Override
  public Music findById(Long id) {
    String query = "select m from Music as m where m.id =:id";
    Music music = entityManager.createQuery(query, Music.class).setParameter("id", id).getSingleResult();
    return music;
  }
}
