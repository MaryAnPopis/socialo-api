package com.socialo.services;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonClient {
    String uploadFile(MultipartFile multipartFile);
}
