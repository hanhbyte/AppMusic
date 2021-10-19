package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String author;
  private String category;
  private String music;

  public Music() {
  }

  public Music(Long id, String name, String author, String category) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.category = category;
  }

  public Music(Long id, String name, String author, String category, String music) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.category = category;
    this.music = music;
  }

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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getMusic() {
    return music;
  }

  public void setMusic(String music) {
    this.music = music;
  }
}
