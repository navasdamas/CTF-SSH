import com.jcraft.jsch.*;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class main  {

    public static void main(String[] args) throws JSchException{

        //Definimos el nombre de usuario y la contraseña del host al que queremos conectarnos
        String username = "user";
        String password = "passwd";

        //Especificamos la dirección IP del host
        String host = "192.168.0.4";

        //Indicamos el puerto donde está corriendo el servicio de SSH. Por defecto es el puerto 22
        int port = 22;

        //Vamos a utilizar la librería JSch que hemos importado a través de Maven
        JSch jsch = new JSch();

        //Creamos una sesión con los parámetros que hemos definido anteriormente
        Session jschSession;
        jschSession = jsch.getSession(username, host, port);
        jschSession.setPassword(password);

        /*IMPORTANTE: Hay que desabilitar la opción "StrictHostKeyChecking". Esta opción comprueba que el host al que
        queremos conectarnos está dentro de nuestros host conocidos.*/
        jschSession.setConfig("StrictHostKeyChecking", "no");

        //Probamos a conectarnos
        try {
            jschSession.connect();
            System.out.println("CONEXION ESTABLECIDA");

            //Cuando queramos cerrar la conexión debemos ejecutar disconnect()
            jschSession.disconnect();

        }catch (JSchException e) {
            System.out.println("FALLO EN LA CONEXION");
        }

        System.out.println("FIN");
    }
}

