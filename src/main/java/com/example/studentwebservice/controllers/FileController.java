package com.example.studentwebservice.controllers;

import com.example.studentwebservice.services.FileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api
@RestController
@RequestMapping("/acc/job/{id}/files")
//@PreAuthorize("hasAuthority('USER')")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping(path = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadJob(@PathVariable Long id, @RequestParam("file")MultipartFile file){
        return fileService.uploadFile(id, file);
    }

    @GetMapping(path = "get", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity getFile(@PathVariable Long id){
        return fileService.downloadFile(id);
    }
}
