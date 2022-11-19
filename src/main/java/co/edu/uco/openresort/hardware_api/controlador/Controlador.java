package co.edu.uco.openresort.hardware_api.controlador;

import co.edu.uco.openresort.hardware_api.dto.AccesoDTO;
import co.edu.uco.openresort.hardware_api.servicio.AccesoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitacion")
public class Controlador {

    @Autowired
    private AccesoHabitacionServicio accesoHabitacionServicio;

    @PostMapping
    public void darAcceso(@RequestBody AccesoDTO accesoDTO) throws Exception {
        accesoHabitacionServicio.darAcceso(accesoDTO.getIdTag(),accesoDTO.getIdHabitacion());
    }
}
