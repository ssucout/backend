package com.example.SSUCout.face;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class FaceService {
    private final ObjectMapper objectMapper;

    @Transactional
    public String sendToFlask(
            RequestSendToFlaskDto dto
    ) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        //헤더를 JSON으로 설정함
        HttpHeaders headers = new HttpHeaders();

        //파라미터로 들어온 dto를 JSON 객체로 변환
        headers.setContentType(MediaType.APPLICATION_JSON);

        String param = objectMapper.writeValueAsString(dto);

        HttpEntity<String> entity = new HttpEntity<String>(param, headers);

        //실제 Flask 서버랑 연결하기 위한 URL
        String url = "http://127.0.0.1:8080/recieve_image";

        //Flask 서버로 데이터를 전송하고 받은 응답 값을 return
        return restTemplate.postForObject(url, entity, String.class);
    }
}
