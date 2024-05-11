package com.mycompany.nitin.photozclone.web;

import com.mycompany.nitin.photozclone.model.Photo;
import com.mycompany.nitin.photozclone.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.print.attribute.standard.Media;

@RestController
public class DownloadController {

    @Autowired
    private PhotozService photozService;

    @GetMapping("/photoz/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
        Photo photo= photozService.get(id);
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition contentDisposition = ContentDisposition
                .builder("attachment") // type: inline
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(contentDisposition);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
