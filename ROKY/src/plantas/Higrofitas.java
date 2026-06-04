package src.plantas;
public class Higrofitas extends Planta {
    private boolean Hojas_grandes;
    Higrofitas(String nombre, float Tiempo_sin_agua, int Agua_necesaria, float crecimiento_semanal, boolean Hojas_grandes){
        super(nombre, Tiempo_sin_agua, Agua_necesaria, crecimiento_semanal);
        this.Hojas_grandes=Hojas_grandes;

    }
    public boolean isHojas_grandes() {
        return Hojas_grandes;
    }
    public void setHojas_grandes(boolean hojas_grandes) {
        Hojas_grandes = hojas_grandes;
    }
@Override
public String darInfoFinal(){
    return (super.darInfoFinal() + " Hojas grandes: "+Hojas_grandes);
    
}
}
