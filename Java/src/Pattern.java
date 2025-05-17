import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number (e.g., 5): ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            int num = n;
            for (int j = 1; j <= n; j++) {
                if (j < i)
                    System.out.print(num-- + " ");
                else
                    System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
