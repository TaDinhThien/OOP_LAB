package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class CongHaiMaTran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận
        System.out.print("Nhập số hàng của ma trận: ");
        int soHang = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int soCot = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau nextInt()

        // Khai báo 2 ma trận và 1 ma trận tổng
        int[][] maTran1 = new int[soHang][soCot];
        int[][] maTran2 = new int[soHang][soCot];
        int[][] tongMaTran = new int[soHang][soCot];

        // Nhập ma trận 1 theo từng dòng
        System.out.println("Nhập ma trận 1 (mỗi dòng " + soCot + " số, cách nhau bởi khoảng trắng):");
        for (int i = 0; i < soHang; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < soCot; j++) {
                maTran1[i][j] = Integer.parseInt(line[j]);
            }
        }

        // Nhập ma trận 2 theo từng dòng
        System.out.println("Nhập ma trận 2 (mỗi dòng " + soCot + " số, cách nhau bởi khoảng trắng):");
        for (int i = 0; i < soHang; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < soCot; j++) {
                maTran2[i][j] = Integer.parseInt(line[j]);
            }
        }

        //  Cộng hai ma trận
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                tongMaTran[i][j] = maTran1[i][j] + maTran2[i][j];
            }
        }

        // In ra ma trận tổng
        System.out.println("Tổng của hai ma trận:");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(tongMaTran[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
