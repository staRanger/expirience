package ruk.paul.testRest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by paul on 30.05.18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplianceDto {
    private String itemid;
    private String type;
    private String state;
}
