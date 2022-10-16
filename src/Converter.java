public class Converter {

    double stepsToKM(int steps) {
        double stepsToSm = steps * 75;
        return stepsToSm / 100000;
    }

    double stepsToKilocalories(int steps) {
        int calorie = steps * 50;
        return (double) calorie / 1000;
    }
}
