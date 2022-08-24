package bms.models;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.event.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@MappedEntity
public class UserModel {

    @Id
    @NotBlank
    @NonNull
    private String email;
    @Nullable
    private String firstName;
    @Nullable
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
