import java.util.Scanner;

public class NgayThangNamHopLe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nam = nhapNam(scanner);
        int thang = nhapThang(scanner);
        int ngay = nhapNgay(scanner, thang, nam);

        System.out.println("Bạn đã nhập ngày hợp lệ: " + ngay + "/" + thang + "/" + nam);
        scanner.close();
    }

    // Hàm yêu cầu nhập năm hợp lệ
    public static int nhapNam(Scanner scanner) {
        int nam = -1;
        while (nam < 0 || String.valueOf(nam).length() != 4) {
            System.out.print("Nhập năm (4 chữ số): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Năm không hợp lệ. Vui lòng nhập lại.");
                scanner.next(); // bỏ dữ liệu không hợp lệ
            }
            nam = scanner.nextInt();
            if (String.valueOf(nam).length() != 4) {
                System.out.println("Năm không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return nam;
    }

    // Hàm yêu cầu nhập tháng hợp lệ (1-12 hoặc tên tháng)
    public static int nhapThang(Scanner scanner) {
        String[] tenThang = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        String[] vietTatThang = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        int thang = -1;

        while (thang == -1) {
            System.out.print("Nhập tháng (số từ 1-12 hoặc tên viết tắt): ");
            String nhap = scanner.next().trim();

            thang = chuyenDoiThang(nhap, tenThang, vietTatThang);
            if (thang == -1) {
                System.out.println("Tháng không hợp lệ. Vui lòng thử lại.");
            }
        }
        return thang;
    }

    // Hàm yêu cầu nhập ngày hợp lệ
    public static int nhapNgay(Scanner scanner, int thang, int nam) {
        int ngay = -1;
        int soNgayToiDa = soNgayTrongThang(thang, nam);

        while (ngay < 1 || ngay > soNgayToiDa) {
            System.out.print("Nhập ngày (từ 1 đến " + soNgayToiDa + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
                scanner.next();
            }
            ngay = scanner.nextInt();

            if (ngay < 1 || ngay > soNgayToiDa) {
                System.out.println("Ngày không hợp lệ. Vui lòng thử lại.");
            }
        }

        return ngay;
    }

    // Hàm chuyển tên, viết tắt, số thành tháng (1-12)
    public static int chuyenDoiThang(String nhap, String[] tenThang, String[] vietTat) {
        try {
            int so = Integer.parseInt(nhap);
            if (so >= 1 && so <= 12) {
                return so;
            }
        } catch (NumberFormatException ignored) {
        }

        for (int i = 0; i < tenThang.length; i++) {
            if (tenThang[i].equalsIgnoreCase(nhap) || vietTat[i].equalsIgnoreCase(nhap)) {
                return i + 1;
            }
        }

        return -1; 
    }

    // Hàm kiểm tra năm nhuận
    public static boolean laNamNhuan(int nam) {
        if (nam % 4 != 0) {
            return false;
        } else if (nam % 100 != 0) {
            return true;
        } else {
            return nam % 400 == 0;
        }
    }

    // Hàm trả về số ngày trong tháng
    public static int soNgayTrongThang(int thang, int nam) {
        int[] ngayThuong = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (thang == 2 && laNamNhuan(nam)) {
            return 29; // tháng 2 năm nhuận
        }

        return ngayThuong[thang - 1];
    }
}
