import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();           
            int choice = readInt();

            switch (choice) {
                case 1: tambahItem(); break;
                case 2: tambahAnggota(); break;
                case 3: pinjamItem(); break;
                case 4: kembalikanItem(); break;
                case 5: lihatStatus(); break;
                case 6: lihatLog(); break;
                case 7: lihatItemDipinjam(); break;
                case 8:
                    System.out.println("Sistem dimatikan.");
                    running = false; 
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 1-8.");
            }
        }

        scanner.close(); 
    }

    static void tambahItem() {
        System.out.println("\n--- Tambah Item ---");
        System.out.println("Pilih tipe item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilihan: ");
        int tipe = readInt();

        System.out.print("Masukkan ID item: ");
        int id = readInt();

        System.out.print("Masukkan judul: ");
        String judul = scanner.nextLine().trim();

        if (tipe == 1) {
            System.out.print("Masukkan nama pengarang: ");
            String pengarang = scanner.nextLine();

            Book book = new Book(judul, id, pengarang);
            System.out.println(library.addItem(book));

        } else if (tipe == 2) {
            System.out.print("Masukkan durasi (menit): ");
            int durasi = readInt();

            DVD dvd = new DVD(judul, id, durasi);
            System.out.println(library.addItem(dvd));

        } else {
            System.out.println("Tipe tidak valid!");
        }
    }

    static void tambahAnggota() {
        System.out.println("\n--- Tambah Anggota ---");

        System.out.print("Masukkan ID anggota: ");
        int id = readInt();

        System.out.print("Masukkan nama anggota: ");
        String nama = scanner.nextLine().trim();

        Member member = new Member(nama, id);
        System.out.println(library.addMember(member));
    }

    static void pinjamItem() {
        System.out.println("\n--- Pinjam Item ---");

        System.out.print("Masukkan ID anggota: ");
        int memberId = readInt();

        System.out.print("Masukkan ID item: ");
        int itemId = readInt();

        System.out.print("Masukkan jumlah hari peminjaman: ");
        int days = readInt();

        try {
            String result = library.borrowItem(memberId, itemId, days);
            System.out.println("Berhasil! " + result);
        } catch (NoSuchElementException e) {
            // Jika ID tidak ditemukan
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Jika hari melebihi batas atau item sudah dipinjam
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            // Jika item tidak tersedia
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void kembalikanItem() {
        System.out.println("\n--- Kembalikan Item ---");

        System.out.print("Masukkan ID anggota: ");
        int memberId = readInt();

        System.out.print("Masukkan ID item: ");
        int itemId = readInt();

        System.out.print("Masukkan jumlah hari keterlambatan (0 jika tepat waktu): ");
        int daysLate = readInt();

        try {
            String result = library.returnItem(memberId, itemId, daysLate);
            System.out.println(result);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void lihatStatus() {
        System.out.println("\n--- Status Perpustakaan ---");
        System.out.println(library.getLibraryStatus());
    }

    static void lihatLog() {
        System.out.println("\n--- Log Aktivitas ---");
        System.out.println(library.getAllLogs());
    }

    static void lihatItemDipinjam() {
        System.out.println("\n--- Item yang Dipinjam Anggota ---");

        System.out.print("Masukkan ID anggota: ");
        int memberId = readInt();

        try {
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.getName() + ":");
            member.getBorrowedItems(); // Method ini langsung print tabel
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void printMenu() {
        System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
        System.out.print("\nPilih menu: ");
    }

    static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value; 
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid, masukkan angka: ");
            }
        }
    }
}