import java.util.Arrays;
import java.util.Scanner;

public class SapXepMangTinhTongTrungBinh {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] my_array1 = new int[n];
        System.out.print("Nhập phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            my_array1[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu: " + Arrays.toString(my_array1));

        Arrays.sort(my_array1);

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(my_array1));

        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }

        double average = (double) sum / n;

        System.out.println("Tổng các phần tử: " + sum);
        System.out.println("Giá trị trung bình: " + average);

        scanner.close();
    }
}
