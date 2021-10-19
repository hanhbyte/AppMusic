package com.demo.model;

import javax.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
  private Long id;
  @NotEmpty(message = "Tên bài hát phải từ 2-800 kí tự")
  @Size(min = 2, max = 255)
  private String name;
  @NotEmpty(message = "Tên tác giả phải từ 2-300 kí tự")
  @Size(min = 2, max = 255)
  private String author;
  @NotEmpty(message = "Tên thể loại phải từ 2-300 kí tự")
  @Size(min = 2, max = 255)
  private String category;
  private MultipartFile music;

  public MusicForm() {
  }

  public MusicForm(Long id, String name, String author, String category,
      MultipartFile music) {
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

  public MultipartFile getMusic() {
    return music;
  }

  public void setMusic(MultipartFile music) {
    this.music = music;
  }
}
