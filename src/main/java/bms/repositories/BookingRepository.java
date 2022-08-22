package bms.repositories;

import bms.models.BookingModel;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface BookingRepository extends CrudRepository<BookingModel, Long> {

}
