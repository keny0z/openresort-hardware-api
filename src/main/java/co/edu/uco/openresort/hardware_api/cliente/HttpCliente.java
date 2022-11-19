package co.edu.uco.openresort.hardware_api.cliente;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface HttpCliente {
    void post(String endPoint, String json) throws IOException, InterruptedException, Exception;
}
