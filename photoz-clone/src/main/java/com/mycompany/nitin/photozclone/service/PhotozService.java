package com.mycompany.nitin.photozclone.service;

import com.mycompany.nitin.photozclone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component
@Service
public class PhotozService {

    private Map<String, Photo> db = new HashMap<String, Photo>(){{
        put("1", new Photo("1", "hello.jpg"));
        put("2", new Photo("2", "hello2.jpg"));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo put(String id, Photo photo) {
         return db.put(id, photo);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }

    //private List<Photo> db = List.of(new Photo("1", "hello.jpg"));
    //List<Photo> db2 = new ArrayList<>();
}
