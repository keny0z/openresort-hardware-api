package co.edu.uco.openresort.hardware_api.repositorio;

import co.edu.uco.openresort.hardware_api.entidad.OperacionTagEntidad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacionTagRepositorio extends MongoRepository<OperacionTagEntidad,Long> {
}
