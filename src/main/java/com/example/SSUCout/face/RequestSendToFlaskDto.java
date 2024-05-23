package com.example.SSUCout.face;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class RequestSendToFlaskDto {
    private String fieldID;
    private MultipartFile multipartFile;
}
