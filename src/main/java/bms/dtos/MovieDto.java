package bms.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    public long id;
    public String name;
    public String description;
    public Timestamp release_date;

}
