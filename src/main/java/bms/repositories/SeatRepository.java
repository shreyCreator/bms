package bms.repositories;

import bms.models.SeatModel;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface SeatRepository extends CrudRepository<SeatModel, Long> {

}
