package efs.task.syntax;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    final int M;
    int n;
    int l;
    Scanner scanner;

    //Do not modify main method
    public static void main(String[] args) {
        try {
            GuessNumberGame game = new GuessNumberGame(args.length > 0 ? args[0] : "");
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GuessNumberGame(String argument) {
        int temp = 0;
        try {
            temp = Integer.parseInt(argument);
            if (temp < 1 || temp > UsefulConstants.MAX_UPPER_BOUND) {
                throw new NumberFormatException();
            }
            l = (int) (Math.log(temp) + 1);
            Random random = new Random();
            n = random.nextInt(temp) + 1;
        } catch (NumberFormatException e) {
            System.out.println(UsefulConstants.WRONG_ARGUMENT);
            throw new IllegalArgumentException();
        }
        M = temp;
    }

    public void play() {
        if (M > 0 && M <= UsefulConstants.MAX_UPPER_BOUND) {
// TODO: 3/13/21
            /**
             * l = attempts number
             * arr = array for user interface
             * M = программа рандомизирует число в диапазоне <1, M>.
             */
            scanner = new Scanner(System.in);
            int[] attempts = new int[l];
            int userNumber;
            int counter = 1;
            System.out.println("# Комментарий: L попыток угадать число : " + l);
            System.out.println("# Комментарий: Случайное число, которое необходимо угадать: " + n);
            System.out.println("Давайте играть. Угадайте число в диапазоне <1, " + M + ">");
            for (int i = 1; i < attempts.length + 1; i++, counter++) {
                System.out.println("Введите номер: ");
                userNumber = scanner.nextInt();
                if (userNumber == n) {
                    System.out.println
                            (UsefulConstants.CONGRATULATIONS + ", " + counter +
                                    " - количество попыток, чтоб угадать число: " + n);
                    break;
                } else if (userNumber < n) {
                    System.out.println(UsefulConstants.TO_LESS);
                } else if (userNumber > n) {
                    System.out.println(UsefulConstants.TO_MUCH);
                }
                if (i == (attempts.length - 1)) {
                    counter++;
                    System.out.println("Введите номер: ");
                    userNumber = scanner.nextInt();
                    if (userNumber == n) {
                        System.out.println
                                (UsefulConstants.CONGRATULATIONS + ", " + counter +
                                        " - количество попыток, чтоб угадать число: " + n);
                        break;
                    } else {
                        System.out.println("Извините, вы достигли лимита попыток(" + l + ") угадать число: " + n);
                        break;
                    }
                }
            }
        }
    }
}