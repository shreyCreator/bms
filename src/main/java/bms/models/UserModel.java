package bms.models;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.event.PrePersist;
import lombok.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@MappedEntity
public class UserModel extends BaseModel {

    @Id
    @NotBlank
    @NonNull
    private String email;

    private String firstName;
    private String lastName;
    @Nullable
    private String address;
    @Nullable
    private String phoneNo;

    @NotBlank
    @NonNull
    private String password;

    @PrePersist
    void encodePassword() {
        this.password = Base64.getEncoder()
                .encodeToString(this.password.getBytes(StandardCharsets.UTF_8));
    }

}
