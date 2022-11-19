package co.edu.uco.openresort.hardware_api.servicio;

public interface AccesoHabitacionServicio {
    void darAcceso(long idTag, int idHabitacion) throws Exception;
    void quitarAcceso(long idTag, int idHabitacion);
}
