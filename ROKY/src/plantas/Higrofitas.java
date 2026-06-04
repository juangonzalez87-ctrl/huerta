package plantas;

public class Higrofitas extends Planta{
    private boolean Hojas_grandes;

    public Higrofitas(String nombre, double tiempoSinAgua, double crecimiento_semanal, double areaSolicitada,
            boolean hojas_grandes) {
        super(nombre, tiempoSinAgua, crecimiento_semanal, areaSolicitada);
        super.calcLitrosAguaNecesitados(areaSolicitada, 5);
        Hojas_grandes = hojas_grandes;
    }

    public boolean isHojas_grandes() {
        return Hojas_grandes;
    }
    public void setHojas_grandes(boolean hojas_grandes) {
        Hojas_grandes = hojas_grandes;
    }

    public void darInfoFinal(){
        System.out.print(super.infoBasica()+ 
        "\nHojas grandes: "+cumple(Hojas_grandes));
    }
}
