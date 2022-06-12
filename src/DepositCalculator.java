import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d ) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);

        return roundValue(pay, 2);
    }
    double calculateSimplePercent(double doubleAmount, double double_year_rate, int deposit_period) {
        return roundValue(doubleAmount+doubleAmount * double_year_rate * deposit_period, 2);
    }
    double roundValue(double value, int places) {
        double ScaLe= Math.pow(10, places);

        return Math.round(value*ScaLe) / ScaLe;
    }

    void calculateDeposit( ) {
        int period;
        int depositType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;

        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        double totalAmount = 0;

        if (depositType == 1) {
            totalAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            totalAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalAmount);
    }
public static void main(String[] args) {
    new DepositCalculator().calculateDeposit();
}




}
