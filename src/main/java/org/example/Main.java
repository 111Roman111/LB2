import java.util.Scanner;
import java.util.Random;

public class Main {
    public static final int MAX_SIZE = 20;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ширину матриці (до 20): ");
        int width = scanner.nextInt();
        System.out.println("Введіть висоту матриці (до 20): ");
        int height = scanner.nextInt();

        int[][] matrix;
        if (width <= 0 || width > MAX_SIZE || height <= 0 || height > MAX_SIZE) {
            System.out.println("Неправильні розміри матриці.");
            return;
        } else {
            System.out.println("Оберіть спосіб створення матриці: 1 - вручну, 2 - рандомно");
            int choice = scanner.nextInt();
            if (choice == 1) {
                matrix = createMatrixManually(width, height, scanner);
            } else if (choice == 2) {
                matrix = createMatrixRandomly(width, height);
            } else {
                System.out.println("Неправильний вибір.");
                return;
            }
        }

        System.out.println("Згенерована матриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);
        double geometricAverage = calculateGeometricAverage(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricAverage);
    }

    public static int[][] createMatrixManually(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];
        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] createMatrixRandomly(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_NUMBER);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    public static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }

    public static double calculateGeometricAverage(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                product *= num;
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }
}