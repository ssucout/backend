package com.example.SSUCout.face;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class FaceApiContoller {
    private final FaceService faceService;
    @PostMapping("/flask")
    public String sendToFlask(
            @RequestBody
            RequestSendToFlaskDto dto
    ) throws JsonProcessingException {
        return faceService.sendToFlask(dto);
    }
}
