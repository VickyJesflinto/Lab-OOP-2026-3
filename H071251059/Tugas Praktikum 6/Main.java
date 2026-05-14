import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine().trim();
            System.out.println();

            switch (input) {
                case "1": tambahItem(); break;
                case "2": tambahAnggota(); break;
                case "3": pinjamItem(); break;
                case "4": kembalikanItem(); break;
                case "5": lihatStatusPerpustakaan(); break;
                case "6": lihatLogAktivitas(); break;
                case "7": lihatItemDipinjamAnggota(); break;
                case "8":
                    System.out.println("Terima kasih. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
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

    private static void tambahItem() {
        System.out.println("Jenis item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilih: ");
        String jenis = scanner.nextLine().trim();

        try {
            System.out.print("Judul: ");
            String title = scanner.nextLine().trim();
            System.out.print("ID Item: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            if (jenis.equals("1")) {
                System.out.print("Pengarang: ");
                String author = scanner.nextLine().trim();
                Book book = new Book(title, id, author);
                System.out.println(library.addItem(book));
            } else if (jenis.equals("2")) {
                System.out.print("Durasi (menit): ");
                int duration = Integer.parseInt(scanner.nextLine().trim());
                Dvd dvd = new Dvd(title, id, duration);
                System.out.println(library.addItem(dvd));
            } else {
                System.out.println("Jenis tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka untuk ID/durasi.");
        }
    }

    private static void tambahAnggota() {
        try {
            System.out.print("Nama Anggota: ");
            String name = scanner.nextLine().trim();
            System.out.print("ID Anggota: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            Member member = new Member(name, id);
            System.out.println(library.addMember(member));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka untuk ID.");
        }
    }

    private static void pinjamItem() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Jumlah hari peminjaman: ");
            int days = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.borrowItem(memberId, itemId, days));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        } catch (NoSuchElementException | IllegalArgumentException | IllegalStateException e) {
            System.out.println("Gagal meminjam: " + e.getMessage());
        }
    }

    private static void kembalikanItem() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Jumlah hari keterlambatan: ");
            int daysLate = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.returnItem(memberId, itemId, daysLate));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Gagal mengembalikan: " + e.getMessage());
        }
    }

    private static void lihatStatusPerpustakaan() {
        System.out.println(library.getLibraryStatus());
    }

    private static void lihatLogAktivitas() {
        System.out.println(library.getAllLogs());
    }

    private static void lihatItemDipinjamAnggota() {
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.getName() + ":");
            member.getBorrowedItems();
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
