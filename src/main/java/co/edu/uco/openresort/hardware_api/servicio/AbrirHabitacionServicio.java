package co.edu.uco.openresort.hardware_api.servicio;

import org.springframework.http.ResponseEntity;

public interface AbrirHabitacionServicio {
    ResponseEntity<?> abrir(long idTag, int idHabitacion) throws Exception;
}
