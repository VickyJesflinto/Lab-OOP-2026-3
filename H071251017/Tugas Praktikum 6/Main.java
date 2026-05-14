import java.util.Scanner;

public class Main {
     static Library library = new Library();
     static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        while (true) {
            printMenu();
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid.\n");
                continue;
            }
            switch (choice) {
                case 1: tambahItem(); break;
                case 2: tambahAnggota(); break;
                case 3: pinjamItem(); break;
                case 4: kembalikanItem(); break;
                case 5: System.out.println(library.getLibraryStatus()); break;
                case 6: System.out.println(library.getAllLogs()); break;
                case 7: lihatItemDipinjam(); break;
                case 8:
                    System.out.println("Terima kasih. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        }
    }

     static void printMenu() {
        System.out.println();
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

     static void tambahItem() {
        System.out.println("Jenis item: 1. Buku  2. DVD");
        System.out.print("Pilih: ");
        String jenis = scanner.nextLine().trim();
        try {
            System.out.print("Judul: ");
            String title = scanner.nextLine().trim();
            System.out.print("ID Item: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (jenis.equals("1")) {
                System.out.print("Penulis: ");
                String author = scanner.nextLine().trim();
                Book book = new Book(title, id, author);
                System.out.println(library.addItem(book));
            } else if (jenis.equals("2")) {
                System.out.print("Durasi (menit): ");
                int duration = Integer.parseInt(scanner.nextLine().trim());
                DVD dvd = new DVD(title, id, duration);
                System.out.println(library.addItem(dvd));
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

     static void tambahAnggota() {
        try {
            System.out.print("Nama anggota: ");
            String name = scanner.nextLine().trim();
            System.out.print("ID Anggota: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            Member member = new Member(name, id);
            System.out.println(library.addMember(member));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

     static void pinjamItem() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Jumlah hari peminjaman: ");
            int days = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.borrowItem(memberId, itemId, days));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

     static void kembalikanItem() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Keterlambatan (hari): ");
            int daysLate = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.returnItem(memberId, itemId, daysLate));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

     static void lihatItemDipinjam() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.name + ":");
            member.getBorrowedItems();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
