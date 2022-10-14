import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                while (true) {
                    int numberOfMonth;
                    System.out.println("Введите номер месяца, в который хотите внести шаги: ");
                    numberOfMonth = scanner.nextInt();
                    if (numberOfMonth < 1 || numberOfMonth > 12) {
                        while (numberOfMonth < 1 || numberOfMonth > 12) {
                            System.out.println("Номер месяца не может быть меньше 1 и больше 12");
                            System.out.println("Введите номер месяца, в который хотите внести шаги: ");
                            numberOfMonth = scanner.nextInt();
                        }
                    }
                    int numberOfDay;
                    System.out.println("Введите номер дня, в который хотите внести шаги:");
                    numberOfDay = scanner.nextInt();
                    if (numberOfDay < 1 || numberOfDay > 30) {
                        while (numberOfDay < 1 || numberOfDay > 30) {
                            System.out.println("Номер дня  не может быть меньше 1 или больше 30");
                            System.out.println("Введите номер дня, в который хотите внести шаги: ");
                            numberOfDay = scanner.nextInt();
                        }
                    }
                    System.out.println("Введите количество шагов, которое вы хотите добавить:");
                    int steps = scanner.nextInt();
                    if (steps < 0) {
                        while (steps < 0) {
                            System.out.println("Количество шагов не может быть меньше нуля");
                            System.out.println("Введите количество шагов, которое вы хотите добавить:");
                            steps = scanner.nextInt();
                        }
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
                        stepTracker.printBurnedKilocalories(numberOfMonth);
                        stepTracker.printTheBestSeriesOfSteps(numberOfMonth);
                        break;
                    }
                }
            } else if (userInput == 3) {
                while (true) {
                    System.out.println("Введите цель по количеству шагов в день:");
                    int goal = scanner.nextInt();
                    if (goal < 0) {
                        while (goal < 0) {
                            System.out.println("Цель не может быть меньше 0 шагов в день.");
                            System.out.println("Введите цель по количеству шагов в день:");
                            goal = scanner.nextInt();
                        }
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


            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("\n" + "Пожалуйста, выберите одно из действий. Для этого введите цифру от 1 до 4: " + "\n" + "1. Ввести количество шагов за определенный день. " + "\n" +
                "2. Напечатать статистику за определённый месяц. " + "\n" + "3. Измените цель по количеству шагов в день. " + "\n" + "4. Выйти из приложения. ");
    }
}
