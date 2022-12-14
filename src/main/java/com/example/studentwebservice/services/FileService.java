package com.example.studentwebservice.services;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@NoArgsConstructor
public class FileService {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private JobService jobService;

    public ResponseEntity uploadFile(Long id, MultipartFile file){
        try{
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();
                jobService.setFileReference(id, getFilePath(resultFilename));
                file.transferTo(new File(getFilePath(resultFilename)));
            }
        }catch(IOException e){
            System.err.println(e);
        }
        return ResponseEntity.ok()
                .body(HttpStatus.OK);
    }

    public ResponseEntity downloadFile(Long id, String fileName) {
        Path path = Paths.get(getFilePath(fileName));
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    public String getFilePath(String fileName){
        return uploadPath + "/" + fileName;
    }
}
