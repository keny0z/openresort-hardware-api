package co.edu.uco.openresort.hardware_api.cliente.implementacion;

import co.edu.uco.openresort.hardware_api.cliente.HttpCliente;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class HttpClienteImplementacion implements HttpCliente {
    @Override
    public void post(String endPoint, String json) throws IOException, InterruptedException, Exception {
        try {

            URL url = new URL(endPoint);//your url i.e fetch data from .
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            OutputStream output = connection.getOutputStream();
            output.write(json.getBytes());
            output.flush();
            output.close();
            System.out.println("Http response code: "+connection.getResponseCode());
            System.out.println("Response from server: "+connection.getResponseMessage());
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + connection.getResponseCode());
            }
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }

}
