package com.example.SSUCout.map;

import com.example.SSUCout.club.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapApiController {
    private final MapService mapService;

    @GetMapping("/first")
    public List<MapView> viewFirst(
    ){
        return mapService.viewFloor(100,199);
    }
    @GetMapping("/second")
    public List<MapView> viewSecond(
    ){
        return mapService.viewFloor(200,299);
    }
    @GetMapping("/third")
    public List<MapView> viewThird(
    ){
        return mapService.viewFloor(300,399);
    }
    @GetMapping("/clubId/{clubId}")
    public Club viewId(
            @PathVariable
            Integer clubId
    ){
        return mapService.findById(clubId);
    }

}