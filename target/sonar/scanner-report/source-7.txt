package cs.software.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        final Scanner sc = new Scanner(System.in);
        final Logger logger = Logger.getLogger(App.class.getName());

        //Creando los centros de FR05
        Logistica Centros = new Logistica();
        Centros.subscribe(18,29,6303970);
        Centros.subscribe(30, 39, 5031117);
        Centros.subscribe(40,49,4183174);
        Centros.subscribe(50,59,3277134);
        Centros.subscribe(60,69,2221241);
        Centros.subscribe(70,79,1271842);
        Centros.subscribe(80,150,647355);

        //--- APLICACION --
        Login session = Login.getSession();
        boolean canLogin = false;
        while(!canLogin) {
            logger.info("Ingresa tu nombre de usuario");
            var username = sc.nextLine();
            canLogin = session.userLogin(username);
        }
        logger.info("Sesion abierta");
        while(Login.isLogged){
            logger.info("Ingresa una accion:");
            logger.info("1 - Ver reporte de todos los centros");
            logger.info( "2 - Ver reporte de un centro en especifico");
            logger.info( "3 - Crear nuevo centro");
            logger.info( "4 - Eliminar un centro");
            logger.info( "5 - Cerrar sesion");
            var option = sc.nextInt();
            switch (option) {
                case 1 -> Centros.formatAllReportes();
                case 2 -> {
                    logger.info("Ingrese el id del centro al que quiere revisar: ");
                    var c = sc.nextInt();
                    Centros.centros.get(c).formatReport();
                }
                case 3 -> {
                    logger.info("Ingresa la edad minima");
                    var l = sc.nextInt();
                    logger.info("Ingresa la edad maxima");
                    var u = sc.nextInt();
                    logger.info("¿Cuantas personas abarca el rango?");
                    var t = sc.nextInt();
                    Centros.subscribe(l, u, t);
                }
                case 4 -> {
                    logger.info("Ingrese el id del centro que desea eliminar");
                    var c = sc.nextInt();
                    Centros.unsubscribe(Centros.centros.get(c));
                }
                case 5 -> Login.logout();
            }
        }
        logger.info("Sesion cerrada");
    }
}
