package co.edu.uco.openresort.hardware_api.servicio.implementacion;

import co.edu.uco.openresort.hardware_api.cliente.HttpCliente;
import co.edu.uco.openresort.hardware_api.servicio.AbrirHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AbrirHabitacionServicioImplementacion implements AbrirHabitacionServicio {

    @Autowired
    private HttpCliente httpCliente;


    @Override
    public ResponseEntity<?> abrir(long idTag, int idHabitacion) throws Exception {
        return httpCliente.post("http://localhost:8080/habtacion/abrir","{\"idTag\":" + idTag + ",\"idHabitacion\":" + idHabitacion + "}");
    }
}
