
import auto.Auto;
import java.time.LocalDateTime;
import java.util.Scanner;
import modelos.Tipo;
import parqueadero.Parqueadero;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        Parqueadero parqueadero = new Parqueadero();

        for (int i = 0; i < 10; i++) {
            Auto autotest = new Auto("AAA11" + i, Tipo.carro, LocalDateTime.now());
            parqueadero.registrarIngreso(autotest);
        }

        while (opcion != 5) {
            System.out.println("-------------------------------------------");
            System.out.println("Opciones: ");
            System.out.println("1. Ingresar auto");
            System.out.println("2. Mostrar capacidad del parqueadero");
            System.out.println("3. Mostrar vehículos");
            System.out.println("4. Retirar vehículo");
            System.out.println("5. Terminar programa");
            System.out.println("-------------------------------------------");

            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Valor inválido, ingresa una de las opciones");
                opcion = 0;
            }

            switch (opcion) {
                case 1:

                    // Revisar y controlar opctionTipo.
                    int opcionTipo = 0;
                    String placa = " ";

                    System.out.println("Ingresa la placa");
                    try {
                        placa = scanner.next();
                        System.out.println("¿Que tipo es?");
                        System.out.println("Opciones: ");
                        System.out.println("1. carro 2. Moto");
                        opcionTipo = scanner.nextInt();

                        if (opcionTipo > 2) {
                            System.out.println("Opción inválida");
                            break;
                        } else {
                            if (opcionTipo == 1) {
                                Auto auto = new Auto(placa, Tipo.carro, LocalDateTime.now());
                                parqueadero.registrarIngreso(auto);
                            } else {
                                Auto auto = new Auto(placa, Tipo.moto, LocalDateTime.now());
                                parqueadero.registrarIngreso(auto);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("placa inválida");
                        break;
                    }

                    break;
                case 2:
                    parqueadero.capacidad();

                    break;
                case 3:
                    parqueadero.getAuto();

                    break;
                case 4:

                    // Usar más funciones que lógica en crudo.
                    String placaSalida = " ";

                    System.out.println("Ingresa la placa");
                    try {
                        placaSalida = scanner.next();
                        Auto autoSalida = new Auto(placaSalida);
                        parqueadero.registrarSalida(autoSalida);
                        break;
                    } catch (Exception e) {
                        System.out.println(e);
                        break;
                    }
            }

        }

        System.out.println(
                "Programa terminado.");
    }
}
