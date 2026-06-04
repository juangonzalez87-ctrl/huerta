package src.plantas;
public class Mesofitas extends Planta{
    private boolean Raices_largas;
    Mesofitas(String nombre, float Tiempo_sin_agua, int Agua_necesaria, float crecimiento_semanal, boolean Raices_largas){
        super(nombre, Tiempo_sin_agua, Agua_necesaria, crecimiento_semanal);
        this.Raices_largas=Raices_largas;

    }
    public boolean isRaices_largas() {
        return Raices_largas;
    }
    public void setRaices_largas(boolean raices_largas) {
        Raices_largas = raices_largas;
    } 
    
@Override
public String darInfoFinal(){
    return (super.darInfoFinal() + " Raices largas: "+Raices_largas);   
}
}
