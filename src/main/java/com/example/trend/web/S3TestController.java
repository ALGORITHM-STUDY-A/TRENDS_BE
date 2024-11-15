package com.example.trend.web;

import com.example.trend.service.S3TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class S3TestController {

    @Autowired
    private S3TestService s3Service;

    @PostMapping(path = "/teams", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadPetImage(
            @RequestPart(value = "fileName") String fileName,
            @RequestPart(value = "file", required = false) MultipartFile multipartFile
    ) throws IOException {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return ResponseEntity.badRequest().body("파일이 전송되지 않았습니다.");
        }

        String extend = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String url = s3Service.upload(fileName, multipartFile, extend);
        log.info("S3 업로드 URL: {}", url);
        return new ResponseEntity<>(url, HttpStatus.OK);
    }



    @GetMapping(path = "/teams/{fileName}")
    public ResponseEntity<byte[]> getPetImage(
            @PathVariable String fileName
    ) throws IOException {
        return s3Service.download(fileName);
    }
}
