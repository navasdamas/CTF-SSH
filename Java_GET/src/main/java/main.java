import java.io.IOException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class main {
    public static void main(String[] args) throws IOException {

        //Creamos un cliente
        final CloseableHttpClient httpClient = HttpClients.createDefault();

        //Establecemos la ruta donde se quiere enviar la petición get
        HttpGet request = new HttpGet("http://mi-server.com:8080/saludo/hola_server");

        //Enviamos la petición y recogemos la respuesta
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Imprimimos el código de respuesta
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();

            //Imprimimos la información que nos envía el servidor
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }
    }
}

