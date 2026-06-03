import java.util.ArrayList;

public class Huerto {
    private ArrayList<Planta>plantas;
    
    private double areaHuerto;
    private double litrosAgua;

    public Huerto(double areaHuerto, double litrosAgua) {
        this.areaHuerto = areaHuerto;
        this.litrosAgua = litrosAgua;
        this.plantas = new ArrayList<>();
    }

    
}
