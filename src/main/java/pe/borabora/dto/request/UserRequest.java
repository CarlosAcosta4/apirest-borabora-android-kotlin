package pe.borabora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String lastname;
    private Integer cellphone;
    private String email;
    private String username;
    private String password;
}