package parqueadero;

import auto.Auto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import modelos.Tipo;

public class Parqueadero {

    int conteoAutos = 0;
    int capacidad = 20;
    int precioCarro = 1000;
    int precioMoto = 2000;
    Scanner scanner = new Scanner(System.in);

    ArrayList<Auto> arrayAutos = new ArrayList<Auto>();

    public Parqueadero() {

    }

    //Esta función debe de tener todas las validaciones
    public void registrarIngreso() {
        int opcionTipo = 0;

        String placa = " ";

        System.out.println("Ingresa la placa");

        try {
            placa = scanner.next();
            System.out.println("¿Que tipo es?");
            System.out.println("Opciones: ");
            System.out.println("1. carro 2. Moto");
            opcionTipo = scanner.nextInt();

            if (opcionTipo > 2 && opcionTipo <= 0) {
                System.out.println("Opción inválida");

            } else {
                if (opcionTipo == 1 && placa.matches("^[A-Z]{3}\\d{3}$") && conteoAutos <= capacidad) {
                    Auto auto = new Auto(placa, Tipo.carro, LocalDateTime.now());
                    arrayAutos.add(auto);
                    conteoAutos++;
                } else {
                    if (placa.matches("^[A-Z]{3}\\d{3}$") && conteoAutos <= capacidad) {
                        Auto auto = new Auto(placa, Tipo.moto, LocalDateTime.now());
                        arrayAutos.add(auto);
                        conteoAutos++;
                    } else {
                        System.out.println("formato de placa inválido o No hay más espacio en el parqueadero");
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("placa inválida");

        }
    }

    // Verificar la salida puede ir dentro del método registrarSalida
    public void registrarSalida() {

        String placaSalida = " ";
        // basta con solo el string

        System.out.println("Ingresa la placa");
        try {
            placaSalida = scanner.next();
            String verificarPlaca = placaSalida;

            boolean existeAuto = false;
            int autoEncontrado = 0;

            Stream<Auto> stream = arrayAutos.stream();

            if (stream.anyMatch(array -> array.getPlaca().equals(verificarPlaca))) {
                arrayAutos.get(autoEncontrado).setSalida();

                if (arrayAutos.get(autoEncontrado).getTipoAuto() == Tipo.carro) {
                    if (arrayAutos.get(autoEncontrado).getMinutosSalida() > 0 && arrayAutos.get(autoEncontrado).getMinutosSalida() <= 59) {
                        double valorSalida = ((arrayAutos.get(autoEncontrado).getHoraSalida() + 1) - arrayAutos.get(autoEncontrado).getHoraSalida()) * precioCarro;
                        System.out.println("El valor a pagar es de: " + valorSalida);
                    } else {
                        double valorSalida = (arrayAutos.get(autoEncontrado).getHoraSalida() - arrayAutos.get(autoEncontrado).getHoraSalida()) * precioCarro;
                        System.out.println("El valor a pagar es de: " + valorSalida);
                    }

                } else {

                    if (arrayAutos.get(autoEncontrado).getMinutosSalida() > 0 && arrayAutos.get(autoEncontrado).getMinutosSalida() <= 59) {
                        double valorSalida = ((arrayAutos.get(autoEncontrado).getHoraSalida() + 1) - arrayAutos.get(autoEncontrado).getHoraSalida()) * precioMoto;
                        System.out.println("El valor a pagar es de: " + valorSalida);
                    } else {
                        double valorSalida = (arrayAutos.get(autoEncontrado).getHoraSalida() - arrayAutos.get(autoEncontrado).getHoraSalida()) * precioMoto;
                        System.out.println("El valor a pagar es de: " + valorSalida);
                    }

                }

                arrayAutos.remove(autoEncontrado);

                System.out.println(" El auto ha salido ");

            } else {
                System.out.println(" El auto no existe");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void getAuto() {

        System.out.println("Lista de autos: ");

        for (Auto auto : arrayAutos) {
            auto.getInfo();
            System.out.println(" ");
        }
    }

    public void capacidad() {
        System.out.println("capacidad es de: " + capacidad);
        System.out.println("Capacidad restante es de: " + (capacidad - arrayAutos.size()));
    }

    public void autoPredeterminado(Auto auto) {
        arrayAutos.add(auto);
    }
}
