import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();


        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            // обработка разных случаев
            if (userInput == 1) {
                while (true) {
                    int numberOfMonth;
                    System.out.println("Введите номер месяца, в который хотите внести шаги: ");
                    numberOfMonth = scanner.nextInt();
                    if (numberOfMonth < 1 || numberOfMonth > 12) {
                        System.out.println("Номер месяца не может быть меньше 1 и больше 12");
                        continue;
                    }
                    int numberOfDay;
                    System.out.println("Введите номер дня, в который хотите внести шаги:");
                    numberOfDay = scanner.nextInt();
                    if (numberOfDay < 1 || numberOfDay > 30) {
                        System.out.println("Номер дня  не может быть меньше 1 или больше 30");
                        continue;
                    }
                    System.out.println("Введите количество шагов, которое вы хотите добавить:");
                    int steps = scanner.nextInt();
                    if (steps < 0) {
                        System.out.println("Количество шагов не может быть меньше нуля");
                        continue;
                    }
                    stepTracker.setStepsInDay(numberOfMonth, numberOfDay, steps);
                    System.out.println("Вы сохранили данные");
                    break;
                }

            } else if (userInput == 2) {
                while (true) {
                    System.out.println("Введите номер месяца от 1 до 12:");
                    int numberOfMonth = scanner.nextInt();
                    if (numberOfMonth < 1 || numberOfMonth > 12) {
                        System.out.println("Вы ввели некорректный номер месяца.");
                    } else {
                        stepTracker.printStepsInDay(numberOfMonth);
                        stepTracker.printAllStepsInMonth(numberOfMonth);
                        stepTracker.printMaxSteps(numberOfMonth);
                        stepTracker.printAverageNumberSteps(numberOfMonth);
                        stepTracker.printStepsInKM(numberOfMonth);
                        stepTracker.printStepsToKilocalories(numberOfMonth);
                        stepTracker.printTheBestSeriesOfSteps(numberOfMonth);
                        break;
                    }
                }
            } else if (userInput == 3) {
                while (true) {
                    System.out.println("Введите цель по количеству шагов в день:");
                    int goal = scanner.nextInt();
                    if (goal < 0) {
                        System.out.println("Цель не может быть меньше 0 шагов в день.");
                        continue;
                    }
                    stepTracker.setStartSteps(goal);
                    System.out.println("Новая цель по количеству шагов в день: " + goal);
                    break;
                }

            } else if (userInput == 4) {
                System.out.println("Выход из приложения");
                return;
            } else {
                System.out.println("Выберите одно из действий с помощью цифр от 1 до 4");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n" + "Пожалуйста, выберите одно из действий. Для этого введите цифру от 1 до 4: " +
                "\n" + "1. Ввести количество шагов за определенный день. " +
                "\n" + "2. Напечатать статистику за определённый месяц. " +
                "\n" + "3. Измените цель по количеству шагов в день. " +
                "\n" + "4. Выйти из приложения. ");
    }
}
