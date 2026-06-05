import java.util.ArrayList;
import plantas.Planta;

public class Huerto {
    private ArrayList<Planta>plantas;
    
    private String nombre;
    //Capacidad
    private double areaHuerto;
    private double litrosAgua;

    private double aguaAConsumir = 0;

    public Huerto(String nombre, double areaHuerto, double litrosAgua) {
        this.nombre = nombre;
        this.areaHuerto = areaHuerto;
        this.litrosAgua = litrosAgua;
        this.plantas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public ArrayList<Planta> getPlantas() {
        return plantas;
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
            System.out.println("+-> "+ p.getNombre() +" <-");
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
