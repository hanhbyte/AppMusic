package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.demo.model.Music;
import com.demo.model.MusicForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.demo.service.IMusicService;

@Controller
@PropertySource("classpath:upload_file.properties")
public class MusicController {

  @Value("${file-upload}")
  private String fileUpload;

  @Autowired
  private IMusicService musicService;

  @GetMapping("/musics")
  public String home(Model model){
    List<Music> musicList = musicService.findAll();
    System.out.println(musicList.size());
    model.addAttribute("list", musicList);
    return "home";
  }

  @GetMapping("/create")
  public ModelAndView createForm(){
    ModelAndView modelAndView = new ModelAndView("create");
    modelAndView.addObject("music", new MusicForm());
    return modelAndView;
  }

  @PostMapping("/create")
  public ModelAndView createNewMusic(@Validated MusicForm musicForm, BindingResult result){
    if (result.hasFieldErrors()){
      System.out.println("Error!!");
      return  new ModelAndView("create");
    }
    MultipartFile multipartFile = musicForm.getMusic();
    String fileName = multipartFile.getOriginalFilename();
    try {
      FileCopyUtils.copy(multipartFile.getBytes(),
          new File(fileUpload +fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Music music = new Music();
    music.setMusic(fileName);
    music.setId(music.getId());
    music.setName(music.getName());
    music.setAuthor(music.getAuthor());
    music.setCategory(music.getCategory());
    musicService.save(music);
    System.out.println(music);
    return new ModelAndView("redirect:/musics");
  }

  @GetMapping("/edit/{id}")
  public ModelAndView showFormEdit(@PathVariable Long id){
    Music music = musicService.findById(id);
    ModelAndView modelAndView = new ModelAndView("/edit");
    modelAndView.addObject("editForm", music);
    return modelAndView;
  }

  @PostMapping("/edit")
  public String editCustomer(@ModelAttribute("editForm") Music music, MultipartFile multipartFile){
    String fileName = multipartFile.getOriginalFilename();
    try {
      FileCopyUtils.copy(multipartFile.getBytes(),
          new File(fileUpload + fileName));
    }catch (IOException e){
      e.printStackTrace();
    }
    music.setMusic(fileName);
    musicService.save(music);
    return "redirect:/musics";
  }

  @GetMapping("/delete/{id}")
  public ModelAndView showDeleteForm(@PathVariable Long id){
    Music blog = musicService.findById(id);
    ModelAndView modelAndView = new ModelAndView("/delete");
    modelAndView.addObject("deleteForm", blog);
    return modelAndView;
  }

  @PostMapping("/delete")
  public String deleteBlog(@ModelAttribute("deleteForm") Music music){
    musicService.delete(music.getId());
    return "redirect:/musics";
  }
}
