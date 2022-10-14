import java.util.Arrays;

public class StepTracker {
    int startSteps = 10000;

    MonthData[] monthToData;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void setStartSteps(int newStartSteps) {
        startSteps = newStartSteps;
    }

    public void setStepsInDay(int numberOfMonth, int numberOfDay, int steps) {
        monthToData[numberOfMonth - 1].days[numberOfDay - 1] = steps;
    }

    void printStepsInDay(int month) {
        for (int i = 0; i < monthToData[month].days.length; i++) {

            System.out.print(i + 1 + " день: " + monthToData[month - 1].days[i]);  //", "
            if (i == monthToData[month].days.length - 1) {
                System.out.print("");
            } else {
                System.out.print(", ");
            }
        }
    }

    void printAllStepsInMonth(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        System.out.println("\n" + "Общее количество шагов за месяц № " + month + " составляет: " + sum);
    }

    void printMaxSteps(int month) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month - 1].days[i] > max) {
                max = monthToData[month - 1].days[i];
                count = i;
            }
        }
        System.out.println("Максимальное пройденное количество шагов: " + max + ". Пройдено в " + (count + 1) + " день месяца.");
    }

    void printAverageNumberSteps(int month) {
        int sum = 0;
        double averageNumber;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        averageNumber = sum / (double) 30;
        System.out.println("Среднее количество шагов: " + (int) averageNumber);
    }

    void printStepsInKM(int month) {
        Converter converter = new Converter();
        double sumKM = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            sumKM += converter.stepsToKM(monthToData[month - 1].days[i]);
        }
        System.out.println("Пройденная дистанция: " + sumKM + " км.");
    }

    void printBurnedKilocalories(int month) {
        Converter converter = new Converter();
        double sumBurnKilocalories = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            sumBurnKilocalories += converter.burnedKilocalories(monthToData[month - 1].days[i]);
        }
        System.out.println("Количество сожжённых килокалорий: " + sumBurnKilocalories);
    }

    void printTheBestSeriesOfSteps(int month) {
        int count = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month - 1].days[i] > startSteps) {
                count++;
            }
        }
        System.out.println("Лучшая серия: " + count);
    }
}

class MonthData {

    int[] days = new int[30];

    public MonthData() {
        Arrays.fill(days, 0);
    }
}
