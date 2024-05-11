package com.mycompany.nitin.photozclone.web;


import com.mycompany.nitin.photozclone.model.Photo;
import com.mycompany.nitin.photozclone.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {

    @Autowired
    private PhotozService photozService;

    @GetMapping("/")
    public String hello(){
        return "Hello, Welcome to page";
    }

    @GetMapping("/nitin")
    public String nitin(){
        return "This is Nitin";
    }

    @GetMapping("/akanksha")
    public String akankshaNitinBaghel(){
        return "This is Akanksha";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photozService.get(id);
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public String remove(@PathVariable String id){
        Photo photo = photozService.get(id);
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        photozService.remove(id);
        return "Deleted Successfully " + photo.getFileName();
    }

    @PostMapping("/photoz")
//    public Photo create(@RequestBody @Valid Photo photo){
//        photo.setId(UUID.randomUUID().toString());
//        db.put(photo.getId(), photo);
//        System.out.println("adding photo");
//        return photo;
//    }
    public Photo save(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
