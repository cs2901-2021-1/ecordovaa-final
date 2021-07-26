package cs.software.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Logistica {
    static final Logger logger = Logger.getLogger(Logistica.class.getName());
    List<Centro> centros = new ArrayList<>();

    public void subscribe(int l, int u, int t){
        Centro c = new Centro(l,u,t);
        c.setId(centros.size() + 1);
        centros.add(c);
        logger.info("Se ha añadido un nuevo centro");
    }

    public void unsubscribe(Centro centro){
        centros.remove(centro);
        logger.info("Se ha eliminado el Centro " + centro.id);
    }

    public boolean addVacunado(Persona p){
        for(Centro c: centros){
            if(c.lowerBound >= p.edad && c.upperBound <= p.edad) {
                c.attachVacunado(p);
                logger.info("Se ha añadido un vacunado al Centro " + c.id);
                return true;
            }
        }
        return false;
    }

    public void formatAllReportes(){
        logger.info("Cantidad de centros: " + centros.size());
        for(Centro c: centros)
            c.formatReport();
        logger.info( "\n");
    }
}
