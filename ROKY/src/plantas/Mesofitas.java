package plantas;

public class Mesofitas extends Planta{
    private boolean Raices_largas;

    public Mesofitas(String nombre, double tiempoSinAgua, double crecimiento_semanal, double areaSolicitada,
            boolean raices_largas) {
        super(nombre, tiempoSinAgua, crecimiento_semanal, areaSolicitada);
        super.calcLitrosAguaNecesitados(areaSolicitada, 3);
        Raices_largas = raices_largas;
    }

    public boolean isRaices_largas() {
        return Raices_largas;
    }
    public void setRaices_largas(boolean raices_largas) {
        Raices_largas = raices_largas;
    } 
    
    public void darInfoFinal(){
        System.out.print(super.infoBasica() + 
        "\nRaices largas: "+cumple(Raices_largas));   
    }
}
