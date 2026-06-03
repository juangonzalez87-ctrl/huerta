package plantas;
public class Planta {
    //Datos ingresados
    protected String nombre;
    protected double Tiempo_sin_agua;
    protected double crecimiento_semanal;
    protected int Agua_necesaria;

    Planta(String nombre, float Tiempo_sin_agua, int Agua_necesaria, float crecimiento_semanal){
        this.nombre=nombre;
        this.Tiempo_sin_agua=Tiempo_sin_agua;
        this.Agua_necesaria=Agua_necesaria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTiempo_sin_agua() {
        return Tiempo_sin_agua;
    }
    public void setTiempo_sin_agua(float Tiempo_sin_agua) {
        this.Tiempo_sin_agua = Tiempo_sin_agua;
    }

    public int getAgua_necesaria() {
        return Agua_necesaria;
    }
    public void setAgua_necesaria(int Agua_necesaria) {
        this.Agua_necesaria = Agua_necesaria;
    }

    public double getCrecimiento_semanal() {
        return crecimiento_semanal;
    }
    public void setCrecimiento_semanal(float crecimiento_semanal) {
        this.crecimiento_semanal = crecimiento_semanal;
    }
    
    public String darInfoFinal(){
        return (" nombre: "+nombre+ " regar cada: "+Tiempo_sin_agua+"h " + " Litros de agua: "+Agua_necesaria+"L" );
    }
}
