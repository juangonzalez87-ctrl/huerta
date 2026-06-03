import java.util.ArrayList;
import plantas.Planta;

public class Huerto {
    private ArrayList<Planta>plantas;
    
    private double areaHuerto;
    private double litrosAgua;

    public Huerto(double areaHuerto, double litrosAgua) {
        this.areaHuerto = areaHuerto;
        this.litrosAgua = litrosAgua;
        this.plantas = new ArrayList<>();
    }

    public double getAreaHuerto() {
        return areaHuerto;
    }
    public void setAreaHuerto(double areaHuerto) {
        this.areaHuerto = areaHuerto;
    }

    public double getLitrosAgua() {
        return litrosAgua;
    }
    public void setLitrosAgua(double litrosAgua) {
        this.litrosAgua = litrosAgua;
    }

    public void añadirPlanta(Planta p){
        plantas.add(p);
    }
    public void mostrarPlantas(){
        System.out.println("Plantas: ");
        for (Planta p : plantas) {
            System.out.println("PLanta: "+p.getNombre());
        }
    }
}
