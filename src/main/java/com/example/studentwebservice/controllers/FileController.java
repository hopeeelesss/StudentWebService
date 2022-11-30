package com.example.studentwebservice.controllers;

import com.example.studentwebservice.services.FileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api
@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping(path = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadJob(@RequestParam("file")MultipartFile file){
        return fileService.uploadFile(file);
    }

    @GetMapping(path = "get", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity getFile(@RequestParam("name") String fileName){
        return fileService.downloadFile(fileName);
    }
}
