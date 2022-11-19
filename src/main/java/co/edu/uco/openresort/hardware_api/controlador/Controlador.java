package co.edu.uco.openresort.hardware_api.controlador;

import co.edu.uco.openresort.hardware_api.dto.AccesoDTO;
import co.edu.uco.openresort.hardware_api.servicio.AbrirHabitacionServicio;
import co.edu.uco.openresort.hardware_api.servicio.AccesoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitacion")
public class Controlador {

    @Autowired
    private AccesoHabitacionServicio accesoHabitacionServicio;
    @Autowired
    private AbrirHabitacionServicio abrirHabitacionServicio;

    @PostMapping("/acceso")
    public void darAcceso(@RequestBody AccesoDTO accesoDTO) throws Exception {
        accesoHabitacionServicio.darAcceso(accesoDTO.getIdTag(),accesoDTO.getIdHabitacion());
    }

    @PostMapping("/abrir")
    public ResponseEntity<?> abrirPuerta(@RequestBody AccesoDTO accesoDTO) throws Exception {
        return abrirHabitacionServicio.abrir(accesoDTO.getIdTag(),accesoDTO.getIdHabitacion());
    }
}
