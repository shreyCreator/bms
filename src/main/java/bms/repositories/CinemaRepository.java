package bms.repositories;

import bms.models.CinemaModel;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface CinemaRepository extends CrudRepository<CinemaModel, Long> {

}
