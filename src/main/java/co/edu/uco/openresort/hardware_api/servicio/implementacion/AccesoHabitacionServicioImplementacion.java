package co.edu.uco.openresort.hardware_api.servicio.implementacion;

import co.edu.uco.openresort.hardware_api.cliente.HttpCliente;
import co.edu.uco.openresort.hardware_api.entidad.OperacionTagEntidad;
import co.edu.uco.openresort.hardware_api.repositorio.OperacionTagRepositorio;
import co.edu.uco.openresort.hardware_api.servicio.AccesoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccesoHabitacionServicioImplementacion implements AccesoHabitacionServicio {

    @Autowired
    private HttpCliente httpCliente;
    @Autowired
    private OperacionTagRepositorio operacionTagRepositorio;

    @Override
    public ResponseEntity<?> darAcceso(long idTag, int idHabitacion) throws Exception {
        OperacionTagEntidad operacionTagEntidad = new OperacionTagEntidad();

        operacionTagEntidad.setTag(idTag);
        operacionTagEntidad.setFecha(LocalDateTime.now());
        operacionTagEntidad.setOperacion("acceso a la habitacion con id: "+ idHabitacion);

        operacionTagRepositorio.insert(operacionTagEntidad);

        return httpCliente.post("http://localhost:8080/habtacion/acceso","{\"idTag\":" + idTag + ",\"idHabitacion\":" + idHabitacion + "}");


    }

    @Override
    public void quitarAcceso(long idTag, int idHabitacion) {

    }
}
