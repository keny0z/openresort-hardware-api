package co.edu.uco.openresort.hardware_api.servicio;

import org.springframework.http.ResponseEntity;

public interface AccesoHabitacionServicio {
    ResponseEntity<?> darAcceso(long idTag, int idHabitacion) throws Exception;
    void quitarAcceso(long idTag, int idHabitacion);
}
