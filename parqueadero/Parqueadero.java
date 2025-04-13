package parqueadero;

import modelos.Tipo;
import auto.Auto;
import java.util.ArrayList;

public class Parqueadero {

    int conteoAutos = 0;
    int capacidad = 20;
    int precioCarro = 1000;
    int precioMoto = 2000;

    ArrayList<Auto> arrayAutos = new ArrayList<Auto>();

    public Parqueadero() {

    }


    //Esta función debe de tener todas las validaciones
    public void registrarIngreso(Auto auto) {

        if (auto.getPlaca().matches("^[A-Z]{3}\\d{3}$") && conteoAutos <= capacidad ) {
            arrayAutos.add(auto);
            conteoAutos++;
        }
        else {
            System.out.println("formato de placa inválido o No hay más espacio en el parqueadero");
        }
    }

    public void registrarSalida(Auto auto) {

        boolean existeAuto = false;
        int autoEncontrado = 0;

        // Mejorar este For con un stream.
        for (int i = 0; i < arrayAutos.size(); i++) {

            if (arrayAutos.get(i).getPlaca().matches(auto.getPlaca())) {
                existeAuto = true;
                autoEncontrado = i;
                System.out.println("auto encontrado");
                break;
            }
        }

        if (existeAuto) {
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
}
