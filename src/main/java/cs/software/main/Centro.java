package cs.software.main;

import java.util.logging.Logger;

public class Centro {
    static final Logger logger = Logger.getLogger(Centro.class.getName());
    public int id;
    public final int upperBound;
    public final int lowerBound;
    private int cantPersonas;
    private int cantPersonasParcial;
    private int cantVacunados;

    public Centro(int l, int u, int t){
        upperBound = u;
        lowerBound = l;
        cantPersonas = t;
    }

    public void setId(int i){
        id = i;
    }

    public int getAvanceVacunacion(){
        return cantVacunados;
    }

    public int getCoberturaVacunacion(){
        return cantVacunados/cantPersonas;
    }

    public void attachVacunado(Persona persona){
        if(persona.vacunaParcial){
            cantPersonas++;
            cantPersonasParcial--;
        }
        cantPersonasParcial++;
        persona.vacunaParcial = true;
    }

    public void formatReport(){
        logger.info("********************* Centro: " + id + "*******************\n");
        logger.info("Avance de vacunacion: " + getAvanceVacunacion());
        logger.info( "Cobertura de vacunacion: " + getCoberturaVacunacion());
        logger.info("Rango de edades: " + upperBound +  " - " + lowerBound);
        logger.info("Personas vacunadas parcialmente: " + cantPersonasParcial);
        logger.info( "Personas vacunadas totalmente: " + cantVacunados);
        logger.info( "Personas totales en el rango: " + cantPersonas);
    }
}
