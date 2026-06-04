package src.plantas;
public class Xerofitas extends Planta {
    private boolean tallo_grueso;
    private boolean espinas;
    Xerofitas(String nombre, float Tiempo_sin_agua, int Agua_necesaria, float crecimiento_semanal, boolean tallo_grueso, boolean espinas){
        super(nombre, Tiempo_sin_agua, Agua_necesaria, crecimiento_semanal);
        this.tallo_grueso=tallo_grueso;
        this.espinas=espinas;

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
    return (super.darInfoFinal() + " Tallo grueso: "+tallo_grueso+ " Espinas: "+espinas);
    
}
}
