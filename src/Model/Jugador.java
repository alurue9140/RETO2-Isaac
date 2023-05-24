package Model;

public class Jugador {
    private String demarcacion;
    private String nombre;
    private int anioNacimiento;
    private double altura;
    private int dorsal;
    private String clubPertenencia;

    public Jugador(String demarcacion, String nombre, int anioNacimiento, double altura, int dorsal, String clubPertenencia) {
        this.demarcacion = demarcacion;
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.altura = altura;
        this.dorsal = dorsal;
        this.clubPertenencia = clubPertenencia;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltura() {
        return altura;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getClubPertenencia() {
        return clubPertenencia;
    }

    public String getDemarcacion() {
        return demarcacion;
    }
}
