package auto;

import java.time.LocalDateTime;
import modelos.Tipo;

public class Auto {

    private int horaIngreso;
    private int horaSalida;
    private int minutosSalida;
    private String placa = " ";
    Tipo tipo;

    public Auto(String placa, Tipo tipo) {

        if (placa.matches("^[A-Z]{3}\\d{3}$")) {

            this.placa = placa;
            this.tipo = tipo;
            LocalDateTime hora = LocalDateTime.now();
            horaIngreso = hora.getHour();
            
        } else {
            System.out.println("formato de placa inválido");
        }

    }

    public void Getinfo() {
        System.out.println("Hora de ingreso: " + horaIngreso);
        System.out.println("Tipo de auto: " + tipo);
        System.out.println("Placa: " + placa);
    }

    public String getPlaca() {
        return placa;
    }

    public Tipo getTipoAuto() {
        return tipo;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public int getMinutosSalida() {
        return minutosSalida;
    }

    public void setSalida() {
        LocalDateTime salida = LocalDateTime.now();
        this.horaSalida = salida.getHour();
        this.minutosSalida = salida.getMinute();
    }

}

