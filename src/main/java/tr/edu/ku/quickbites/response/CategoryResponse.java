package tr.edu.ku.quickbites.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
    private String category;
}
