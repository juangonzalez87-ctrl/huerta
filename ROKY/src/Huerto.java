import java.util.ArrayList;
import plantas.Planta;

public class Huerto {
    private ArrayList<Planta>plantas;
    
    //Capacidad
    private double areaHuerto;
    private double litrosAgua;

    private double aguaAConsumir = 0;

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

    public void añadirPlanta(Planta p) {
        actualizarAguaAConsumir();

        if (!(aguaAConsumir + p.getLitrosAguaNecesitados() >= litrosAgua)){
            plantas.add(p);
        }else{
            System.out.println("(!) La planta: "+p.getNombre()+", supera la capacidad del huerto");
        }
    }

    public void actualizarAguaAConsumir(){
        if(!plantas.isEmpty()){
            for (Planta p : plantas) {
                aguaAConsumir += p.getLitrosAguaNecesitados();
            }
        }
    }
    
    public void mostrarPlantas() {
        System.out.println("Plantas: ");
        for (Planta p : plantas) {
            System.out.println("PLanta: "+p.getNombre());
        }
    }

    public void mostrarNecesidadRiego(double diasDesdeUltimoRiego) {
        for (Planta p : plantas) {
            if (p.necesitaRiego(diasDesdeUltimoRiego)) {
                System.out.println(p.getNombre() + " necesita riego.");
            }
        }
    }
}
