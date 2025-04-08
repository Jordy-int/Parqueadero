import java.time.Duration;
import java.time.LocalDateTime;

public class test{

    // Tarifa por hora (puedes ajustarla según necesites)
    private static final double TARIFF_PER_HOUR = 5.0;

    public static void main(String[] args) {
        // Hora de ingreso y salida (ejemplo)
        LocalDateTime entryTime = LocalDateTime.of(2025, 3, 25, 10, 30);
        LocalDateTime exitTime = LocalDateTime.of(2025, 3, 25, 14, 45);

        // Calcular el monto a cobrar
        double totalFee = calculateFee(entryTime, exitTime);

        System.out.println("Total a cobrar: $" + totalFee);
    }

    public static double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        // Calcular la duración en minutos
        Duration duration = Duration.between(entryTime, exitTime);
        long minutes = duration.toMinutes();

        // Convertir minutos a horas, redondeando hacia arriba para cobrar por hora completa
        double hours = Math.ceil(minutes / 60.0);

        // Calcular el monto total
        return hours * TARIFF_PER_HOUR;
    }
}
