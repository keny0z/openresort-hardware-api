package co.edu.uco.openresort.hardware_api.servicio.implementacion;

import co.edu.uco.openresort.hardware_api.Credenciales;
import co.edu.uco.openresort.hardware_api.cliente.HttpCliente;
import co.edu.uco.openresort.hardware_api.entidad.OperacionTagEntidad;
import co.edu.uco.openresort.hardware_api.repositorio.OperacionTagRepositorio;
import co.edu.uco.openresort.hardware_api.servicio.AbrirHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AbrirHabitacionServicioImplementacion implements AbrirHabitacionServicio {

    @Autowired
    private HttpCliente httpCliente;
    @Autowired
    private OperacionTagRepositorio operacionTagRepositorio;


    @Override
    public ResponseEntity<?> abrir(long idTag, int idHabitacion) throws Exception {
        OperacionTagEntidad operacionTagEntidad = new OperacionTagEntidad();

        operacionTagEntidad.setTag(idTag);
        operacionTagEntidad.setFecha(LocalDateTime.now());
        operacionTagEntidad.setOperacion("ingreso a la habitacion con id: "+ idHabitacion);


        ResponseEntity respuesta = httpCliente.post(Credenciales.ENDPOINT_OPENRESORT_ABRIR,"{\"idTag\":" + idTag + ",\"idHabitacion\":" + idHabitacion + "}");

        //La comparacion debe ser por status code y no por body
        if (respuesta.getBody().toString().equals("true")){
            operacionTagRepositorio.insert(operacionTagEntidad);
        }

        return respuesta;
    }
}
