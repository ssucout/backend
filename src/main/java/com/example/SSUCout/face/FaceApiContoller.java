package com.example.SSUCout.face;


import com.example.SSUCout.club.ClubFaceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/face")
public class FaceApiContoller {
    private final FaceService faceService;

//    @PostMapping("")
//    public ResponseEntity<Integer> analyzeImage(
//            @RequestParam(value = "file", required = false)
//            MultipartFile file
//    ) {
//        try {
//            if (file == null || file.isEmpty()) {
//                return ResponseEntity.badRequest().body(null);
//            }
//
//            ResponseEntity<String> response = faceService.sendToFlask(file);
//
//            Integer predicted_class = faceService.parseFlaskResponse(response);
//
//            Integer clubId = faceService.getRandomClubId(predicted_class);
//            return ResponseEntity.ok(clubId);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body(null);
//        }
        @PostMapping("")
        public ClubFaceDTO analyzeImage(
                @RequestParam(value = "file", required = false)
                        MultipartFile file
    ) {
        try{
                ResponseEntity<String> response = faceService.sendToFlask(file);

                Integer predicted_class = faceService.parseFlaskResponse(response);

                Integer clubId = faceService.getRandomClubId(predicted_class);
                return faceService.analyzeImage2(clubId);

        } catch (IOException e) {
            return null;
        }

}
    }



