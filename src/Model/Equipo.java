package Model;

public class Equipo {
    private String pais;
    private String competicion;
    private String entrenador;
    private String nombre;
    private int anoF;

    public Equipo(String pais, String competicion, String entrenador,String nombre, int anoF) {
        this.pais = pais;
        this.competicion = competicion;
        this.entrenador = entrenador;
        this.nombre = nombre;
        this.anoF = anoF;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getCompeticion() {
        return competicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnoF() {
        return anoF;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public String getPais() {
        return pais;
    }
}

