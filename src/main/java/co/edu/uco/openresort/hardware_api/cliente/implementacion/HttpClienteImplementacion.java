package co.edu.uco.openresort.hardware_api.cliente.implementacion;

import co.edu.uco.openresort.hardware_api.cliente.HttpCliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class HttpClienteImplementacion implements HttpCliente {
    @Override
    public ResponseEntity<?> post(String endPoint, String json) throws IOException, InterruptedException, Exception {
        try {

            URL url = new URL(endPoint);//your url i.e fetch data from .
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // For POST only - START
            connection.setDoOutput(true);
            OutputStream output = connection.getOutputStream();
            output.write(json.getBytes());
            output.flush();
            output.close();
            // For POST only - END

            connection.disconnect();

            System.out.println("Http response code: "+connection.getResponseCode());

            //Get response from server
            InputStream is = connection.getInputStream();
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            int len;
            byte[] bytes = new byte[200];

            while ((len = is.read(bytes)) != -1) {
                writer.write(bytes, 0, len);
            }
            is.close();

            String response = new String(writer.toByteArray());
            System.out.println("Response from server: "+ response);

            return new ResponseEntity<>(response, HttpStatus.OK);
            
        } catch (Exception e) {
            System.out.println("Exception in NetClientPost:- " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
