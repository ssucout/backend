package com.example.SSUCout.face;

import com.example.SSUCout.club.Club;
import com.example.SSUCout.club.ClubFaceDTO;
import com.example.SSUCout.club.ClubRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class FaceService {
    private final ClubRepository clubRepository;

    @Value("${flask.server.url}")
    private String flaskServerUrl;

    public Integer getRandomClubId(Integer predicted_class) {
        String clubCategory;
        if (predicted_class == 1) clubCategory = "봉사";
        else if (predicted_class == 2) clubCategory = "연행예술";
        else if (predicted_class == 3) clubCategory = "창작";
        else if (predicted_class == 4) clubCategory = "체육";
        else if (predicted_class == 5) clubCategory = "학술";
        else if (predicted_class == 6) clubCategory = "종교";
        else if (predicted_class == 7) clubCategory = "교양";
        else throw new IllegalArgumentException("분과의 번호가 1~6을 벗어납니다 : " + predicted_class);

        List<Club> clubList = clubRepository.findAllByClubCategory(clubCategory);
        Random random = new Random();
        Club randomClub = clubList.get(random.nextInt(clubList.size()));
        return randomClub.getClubId();
    }

    public ResponseEntity<String> sendToFlask(MultipartFile file) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(flaskServerUrl, HttpMethod.POST, requestEntity, String.class);
    }

    public Integer parseFlaskResponse(ResponseEntity<String> response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FaceResponse faceResponse = mapper.readValue(response.getBody(), FaceResponse.class);
        return faceResponse.getPredicted_class();
    }

    public ClubFaceDTO analyzeImage2(Integer clubId){
        Club club = clubRepository.findByClubId(clubId);
        return ClubFaceDTO.toFaceDto(club);

    }
}