
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

        // hacer un método dentro del parqueadero que sea para testear.
        for (int i = 0; i < 10; i++) {
            Auto autotest = new Auto("AAA11" + i, Tipo.carro, LocalDateTime.now());
            parqueadero.autoPredeterminado(autotest);
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
                    parqueadero.registrarIngreso();

                    break;
                case 2:
                    parqueadero.capacidad();

                    break;
                case 3:
                    parqueadero.getAuto();

                    break;
                case 4:
                    parqueadero.registrarSalida();
                    break;
            }

        }

        System.out.println(
                "Programa terminado.");
    }
}
