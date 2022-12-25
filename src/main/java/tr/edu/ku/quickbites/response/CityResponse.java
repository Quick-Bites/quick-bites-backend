package tr.edu.ku.quickbites.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class CityResponse {
    private List<String> cities;
}
