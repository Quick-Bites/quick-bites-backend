package tr.edu.ku.quickbites.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.ku.quickbites.response.CityResponse;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CityController {
    @GetMapping("/cities")
    public ResponseEntity<CityResponse> getUsers() {
        return ResponseEntity.ok()
                .body(CityResponse.builder()
                .cities(List.of("Istanbul", "Izmir", "Ankara"))
                .build());
    }
}
