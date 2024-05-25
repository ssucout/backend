package com.example.SSUCout.face;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/face")
public class FaceApiContoller {
    private final FaceService faceService;
    @PostMapping("/upload")
    public String sendToFlask(
            @RequestBody
            RequestSendToFlaskDto dto
    ) throws JsonProcessingException {
        return faceService.sendToFlask(dto);
    }
}
