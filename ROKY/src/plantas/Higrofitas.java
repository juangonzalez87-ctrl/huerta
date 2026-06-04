package plantas;
public class Higrofitas extends Planta{
    private boolean Hojas_grandes;

    public Higrofitas(String nombre, double tiempoSinAgua, double crecimiento_semanal, double areaSolicitada,
            boolean hojas_grandes) {
        super(nombre, tiempoSinAgua, crecimiento_semanal, areaSolicitada);
        Hojas_grandes = hojas_grandes;
    }

    public boolean isHojas_grandes() {
        return Hojas_grandes;
    }
    public void setHojas_grandes(boolean hojas_grandes) {
        Hojas_grandes = hojas_grandes;
    }

    @Override
    public String darInfoFinal(){
        super.calcLitrosAguaNecesitados(areaSolicitada, 5);
        return (super.darInfoFinal() + " Hojas grandes: "+Hojas_grandes);
    }
}
