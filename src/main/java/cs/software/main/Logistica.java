package cs.software.main;

import java.util.List;

public class Logistica {
    List<Centro> centros;

    public void subscribe(int l, int u, int t){
        Centro c = new Centro(l,u,t);
        c.id = centros.size() + 1;
        centros.add(c);
    }

    public void unsubscribe(Centro centro){
        centros.remove(centro);
    }

    public boolean addVacunado(Persona p){
        for(Centro c: centros){
            if(c.lowerBound >= p.edad && c.upperBound <= p.edad) {
                c.attachVacunado(p);
                return true;
            }
        }
        return false;
    }

    public void formatAllReportes(){
        for(Centro c: centros)
            c.formatReport();
    }
}
