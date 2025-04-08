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


    //registrar auto
    public void registrarIngreso(Auto auto) {
        if (conteoAutos <= capacidad) {
            arrayAutos.add(auto);
            conteoAutos++;
        } else {
            System.out.println("No hay más espacio");
        }
    }

    public void registrarSalida(Auto auto) {

        boolean existeAuto = false;
        int autoEncontrado = 0;

        for (int i = 0; i < arrayAutos.size(); i++) {

            // if (arrayAutos.get(i).getPlaca().contains(auto.getPlaca()) && arrayAutos.get(i).getTipoAuto().equals(auto.getTipoAuto())) {
            //     existeAuto = true;
            //     autoEncontrado = i;
            //     break;
            // }
            if (arrayAutos.get(i).getPlaca().matches(auto.getPlaca())) {
                existeAuto = true;
                autoEncontrado = i;
                System.out.println("auto encontrado");
                break;
            }
        }

        if (existeAuto) {
            auto.setSalida();

            if (auto.getTipoAuto() == Tipo.carro) {
                if (auto.getMinutosSalida() > 0 && auto.getMinutosSalida() <= 59) {
                    double valorSalida = ((auto.getHoraSalida() + 1) - auto.getHoraSalida()) * precioCarro;
                    System.out.println("El valor a pagar es de: " + valorSalida);
                } else {
                    double valorSalida = (auto.getHoraSalida() - auto.getHoraSalida()) * precioCarro;
                    System.out.println("El valor a pagar es de: " + valorSalida);
                }

            } else {

                if (auto.getMinutosSalida() > 0 && auto.getMinutosSalida() <= 59) {
                    double valorSalida = ((auto.getHoraSalida() + 1) - auto.getHoraSalida()) * precioMoto;
                    System.out.println("El valor a pagar es de: " + valorSalida);
                } else {
                    double valorSalida = (auto.getHoraSalida() - auto.getHoraSalida()) * precioMoto;
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
            auto.Getinfo();
            System.out.println(" ");
        }
    }

    public void capacidad() {
        System.out.println("capacidad es de: " + capacidad);
        System.out.println("Capacidad restante es de: " + (capacidad - arrayAutos.size()));
    }
}
