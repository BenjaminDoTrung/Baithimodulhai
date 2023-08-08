import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien {
    public static List<SinhVien> listSinhVien = new ArrayList<>();
    public static void themDSSinhVienTuFile(String path) {          // Phương thức đọc file csv

        try {
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while (true) {
                line = bf.readLine();
                if (line == null) {
                    break;
                }
                String[] csv = line.split(",");
                int maSinhVien = Integer.parseInt(csv[0]);
                String hoTen = csv[1];
                int tuoi = Integer.parseInt(csv[2]);
                String gioiTinh = csv[3];
                String diaChi = csv[4];
                double diemTrungBinh = Double.parseDouble(csv[5]);

                SinhVien sinhVien1 = new SinhVien(maSinhVien, hoTen, tuoi, gioiTinh, diaChi, diemTrungBinh);
                QuanLySinhVien.listSinhVien.add(sinhVien1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void hienThiDanhSachSinhVien(){       // phương thức hiển thị dnah sách sinh viên
        for (int i = 0; i < listSinhVien.size(); i++) {
            System.out.println("Mã sinh Viên: " + listSinhVien.get(i).getMaSinhVien() + " Họ Tên: " +
                    listSinhVien.get(i).getHoTen() + " tuổi: " + listSinhVien.get(i).getTuoi() + " Giới Tính: " +
                     listSinhVien.get(i).getGioiTinh() + " Địa chỉ: " + listSinhVien.get(i).getDiaChi() + " Điểm Trung Bình: " +
                    listSinhVien.get(i).getDiemTrungBinh());
        }
    }

    public static void themSinhVien(){
       try {
           Scanner scanner = new Scanner(System.in);
           Scanner scanner1 = new Scanner(System.in);
           System.out.println("Nhập vào mã sinh viên:");
           int maSinhVien = scanner.nextInt();
           System.out.println("Nhập vào họ tên sinh viên");
           String ten = scanner1.nextLine();
           System.out.println("Nhập vào tuổi sinh viên:");
           int tuoi = scanner.nextInt();
           System.out.println("Nhập vào giới tính của sinh viên:");
           String gioiTinh = scanner1.nextLine();
           System.out.println("Nhập vào địa chỉ:");
           String diaChi = scanner1.nextLine();
           System.out.println("Nhập vào điểm trung bình");
           double diemTB = Double.parseDouble(scanner1.nextLine());

           SinhVien sinhVien = new SinhVien(maSinhVien, ten, tuoi, gioiTinh, diaChi, diemTB);
           listSinhVien.add(sinhVien);
       } catch (Exception e){
           e.printStackTrace();
       }
    }
    public static void suaThongTinSV(){
       try {
           boolean check = true;
           while (check){
               Scanner scanner = new Scanner(System.in);
               Scanner scanner1 = new Scanner(System.in);
               System.out.println("Nhập vào mã sinh viên cần sửa");
               QuanLySinhVien.hienThiDanhSachSinhVien();
               int maSinhVien = scanner.nextInt();
               for (int i = 0; i < listSinhVien.size(); i++) {
                   if (maSinhVien == listSinhVien.get(i).getMaSinhVien()) {
                       System.out.println("Nhập vào mã sinh viên mới:");
                       listSinhVien.get(i).setMaSinhVien(scanner.nextInt());
                       System.out.println("Nhập vào họ tên sinh viên");
                       listSinhVien.get(i).setHoTen(scanner1.nextLine());
                       System.out.println("Nhập vào tuổi sinh viên:");
                       listSinhVien.get(i).setTuoi(scanner.nextInt());
                       System.out.println("Nhập vào giới tính của sinh viên:");
                       listSinhVien.get(i).setGioiTinh(scanner1.nextLine());
                       System.out.println("Nhập vào địa chỉ:");
                       listSinhVien.get(i).setDiaChi(scanner1.nextLine());
                       System.out.println("Nhập vào điểm trung bình");
                       listSinhVien.get(i).setDiemTrungBinh(Double.parseDouble(scanner1.nextLine()));
                       check = false;
                   } else {
                       System.out.println("Không tìm được sinh viên với mã sinh viên trên");
                       break;
                   }
               }
           }
       } catch (Exception e){
           e.printStackTrace();
       }
    }
    public static void xoaSinhVien(){           // Phương thức xóa sinh viên theo mã sinh viên
        try {
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("Nhập vào mã sinh viên muốn xóa:");
                int maSinhVien = scanner.nextInt();
                for (int i = 0; i < listSinhVien.size(); i++) {
                    if (maSinhVien == listSinhVien.get(i).getMaSinhVien()) {
                        listSinhVien.remove(listSinhVien.get(i));
                        break;
                    } else if (maSinhVien != listSinhVien.get(i).getMaSinhVien()){
                        System.out.println("Không tìm thấy sinh viên với mã trên, mời nhập lại");
                    } else {
                        System.exit(maSinhVien);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void ghiDSVaoFile(String duongDanFile, boolean trueAndFlase){
        try {
            FileWriter fr = new FileWriter(duongDanFile, trueAndFlase);
            BufferedWriter br = new BufferedWriter(fr);
            for (int i = 0; i < listSinhVien.size(); i++) {
                String thongTinSV =listSinhVien.get(i).getMaSinhVien() + "," + listSinhVien.get(i).getHoTen()
                        + "," + listSinhVien.get(i).getTuoi() + "," + listSinhVien.get(i).getGioiTinh()
                        + "," + listSinhVien.get(i).getDiaChi() + "," + listSinhVien.get(i).getDiemTrungBinh() + "\n";
                br.write(thongTinSV);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sapXep(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào cách sắp xếp muốn chọn");
            System.out.println("1. Sắp xếp tăng dần");
            System.out.println("2. Sắp xếp giảm dần");
            System.out.println("3. Thoát");
            int number = scanner.nextInt();
            if (number == 1){
                listSinhVien.sort(((o1, o2) -> (int) (o1.getDiemTrungBinh() - o2.getDiemTrungBinh())));
            } else if (number == 2){
                listSinhVien.sort(((o1, o2) -> (int) (o2.getDiemTrungBinh() - o1.getDiemTrungBinh())));
            } else if (number == 3){
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
