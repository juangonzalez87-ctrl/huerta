package plantas;

public class Xerofitas extends Planta{
    private boolean tallo_grueso;
    private boolean espinas;
    
    public Xerofitas(String nombre, double tiempoSinAgua, double crecimiento_semanal, double areaSolicitada,
            boolean tallo_grueso, boolean espinas) {
        super(nombre, tiempoSinAgua, crecimiento_semanal, areaSolicitada);
        this.tallo_grueso = tallo_grueso;
        this.espinas = espinas;
    }

    public boolean isTallo_grueso() {
        return tallo_grueso;
    }
    public void setTallo_grueso(boolean tallo_grueso) {
        this.tallo_grueso = tallo_grueso;
    }
    
    public boolean isEspinas() {
        return espinas;
    }
    public void setEspinas(boolean espinas) {
        this.espinas = espinas;
    }
    
    @Override
    public String darInfoFinal(){
        super.calcLitrosAguaNecesitados(areaSolicitada, 1);
        return (super.darInfoFinal() + " Tallo grueso: "+tallo_grueso+ " Espinas: "+espinas);
    }
}
