import java.util.ArrayList;
import java.util.Scanner;
import plantas.Planta;

public class Gestion {
    Scanner sc = new Scanner(System.in); 

    private ArrayList<Huerto>huertos;
    private Huerto huertoTrabajado;
    private Planta plantaTrabajada;

    public Gestion(ArrayList<Huerto> huertos) {
        this.huertos = huertos;
    }

    public void mostrarHuertos(){
        for (Huerto h : huertos) {
            System.out.println("+-> "+ h.getNombre() +" <-");
        }
    }

    public Huerto getHuertoTrabajado() {
        return huertoTrabajado;
    }
    public void setHuertoTrabajado(Huerto huertoTrabajado) {
        this.huertoTrabajado = huertoTrabajado;
    }

    public Planta getPlantaTrabajada() {
        return plantaTrabajada;
    }
    public void setPlantaTrabajada(Planta plantaTrabajada) {
        this.plantaTrabajada = plantaTrabajada;
    }
}   
