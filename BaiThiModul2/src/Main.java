import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String part = "C:\\Users\\admin\\Desktop\\java\\untitled1\\src\\file\\listSinhVien.csv";
        String part2 = "C:\\Users\\admin\\Desktop\\java\\untitled1\\src\\file\\fileNew.csv";
        QuanLySinhVien.themDSSinhVienTuFile(part);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên mới vào danh sách");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên khỏi danh sách");
            System.out.println("5. Sắp xếp danh sách");
            System.out.println("6. Ghi dữ liệu vào file");
            System.out.println();
            System.out.println("Chọn phương thức");
            int check = 0;
            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    int choose = Integer.parseInt(scanner.nextLine());

                    switch (choose) {
                        case 1:
                            QuanLySinhVien.hienThiDanhSachSinhVien();
                            check = 6;
                            break;
                        case 2:
                            QuanLySinhVien.themSinhVien();
                            check = 6;
                            break;
                        case 3:
                            QuanLySinhVien.suaThongTinSV();
                            check = 6;
                            break;
                        case 4:
                            QuanLySinhVien.xoaSinhVien();
                            check = 6;
                            break;
                        case 5:
                            QuanLySinhVien.sapXep();
                            check = 6;
                            break;
                        case 6:
                            QuanLySinhVien.ghiDSVaoFile(part2, false);
                            check = 6;
                            break;
                        case 0:
                            System.exit(0);
                            check = 6;
                            break;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } while (check < 2);
        }
    }
}