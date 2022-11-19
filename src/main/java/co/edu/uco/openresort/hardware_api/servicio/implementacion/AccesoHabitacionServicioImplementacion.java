package co.edu.uco.openresort.hardware_api.servicio.implementacion;

import co.edu.uco.openresort.hardware_api.cliente.HttpCliente;
import co.edu.uco.openresort.hardware_api.servicio.AccesoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesoHabitacionServicioImplementacion implements AccesoHabitacionServicio {

    @Autowired
    private HttpCliente httpCliente;

    @Override
    public void darAcceso(long idTag, int idHabitacion) throws Exception {
        httpCliente.post("http://localhost:8080/habtacion/acceso","{\"idTag\":" + idTag + ",\"idHabitacion\":" + idHabitacion + "}");
    }

    @Override
    public void quitarAcceso(long idTag, int idHabitacion) {

    }
}
