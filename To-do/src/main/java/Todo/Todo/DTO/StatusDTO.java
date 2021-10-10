package Todo.Todo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO implements Serializable {

    @JsonProperty("code")
    private Integer code;

    @NotNull
    @JsonProperty("message")
    private String message;

}
