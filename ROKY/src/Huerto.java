package plantas;
public abstract class Planta {
    //Datos ingresados
    protected String nombre;
    protected double tiempoSinAgua;
    protected double crecimiento_semanal;
    protected double areaSolicitada;
    protected double litrosAguaNecesitados;
    
    public Planta(String nombre, double tiempoSinAgua, double crecimiento_semanal, double areaSolicitada) {
        this.nombre = nombre;
        this.tiempoSinAgua = tiempoSinAgua;
        this.crecimiento_semanal = crecimiento_semanal;
        this.areaSolicitada = areaSolicitada;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTiempoSinAgua() {
        return tiempoSinAgua;
    }
    public void setTiempoSinAgua(double tiempoSinAgua) {
        this.tiempoSinAgua = tiempoSinAgua;
    }

    public double getCrecimiento_semanal() {
        return crecimiento_semanal;
    }
    public void setCrecimiento_semanal(double crecimiento_semanal) {
        this.crecimiento_semanal = crecimiento_semanal;
    }

    public double getAreaSolicitada() {
        return areaSolicitada;
    }
    public void setAreaSolicitada(double areaSolicitada) {
        this.areaSolicitada = areaSolicitada;
        calcLitrosAguaNecesitados(areaSolicitada, areaSolicitada);
    }

    public double getLitrosAguaNecesitados(){
        return litrosAguaNecesitados;
    }

    public void calcLitrosAguaNecesitados(double areaSolicitada, double litrosAprox) {
        litrosAguaNecesitados = this.areaSolicitada*litrosAprox;
    }

    public String cumple(boolean c) {
        return c ? "si":"no";
    }

    public double crecimientoEstimado(int semanas) {
        return crecimiento_semanal * semanas;
    }
    
    public boolean necesitaRiego(double diasDesdeUltimoRiego) {
        return diasDesdeUltimoRiego >= tiempoSinAgua;
    }
    
    public String infoBasica() {
        return "El agua necesaria es " + litrosAguaNecesitados + "L en " + areaSolicitada +
               "m^2,\n tolera " + tiempoSinAgua + " días sin agua \ncrece " +
               crecimiento_semanal + " cm/semana";
    }

}
