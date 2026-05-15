import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> tambahItem();
                    case 2 -> tambahMember();
                    case 3 -> pinjamItem();
                    case 4 -> kembalikanItem();
                    case 5 -> System.out.println(library.getLibraryStatus());
                    case 6 -> System.out.println(library.getAllLogs());
                    case 7 -> handleViewBorrowedItems();
                    case 8 -> { running = false; System.out.println("Terima kasih!"); }
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void tambahItem() {
        System.out.print("Jenis item (Book/DVD): ");
        String type = scanner.nextLine();
        System.out.print("Judul: ");
        String title = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (type.equalsIgnoreCase("Book")) {
            System.out.print("Penulis: ");
            String author = scanner.nextLine();
            library.addItem(new Book(title, id, author));
        } else if (type.equalsIgnoreCase("DVD")) {
            System.out.print("Durasi (menit): ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            library.addItem(new DVD(title, id, duration));
        }
        System.out.println("Item berhasil ditambahkan!");
    }

    private static void tambahMember() {
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("ID Member: ");
        String memberId = scanner.nextLine();
        library.addMember(new Member(name, memberId));
        System.out.println("Anggota berhasil ditambahkan!");
    }

    private static void pinjamItem() {
        System.out.print("ID Item: ");
        int idItem = scanner.nextInt();
        System.out.print("ID Member: ");
        String idMem = scanner.next();
        System.out.print("Jumlah hari: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        LibraryItem item = library.findItemById(idItem);
        Member member = library.findMemberById(idMem);

        library.getLogger().logBorrow(item.getTitle(), member.getName());
        System.out.println("✅ " + member.borrow(item, days));
    }

    private static void kembalikanItem() {
        System.out.print("ID Item: ");
        int idItem = scanner.nextInt();
        System.out.print("ID Member: ");
        String idMem = scanner.next();
        System.out.print("Hari terlambat: ");
        int late = scanner.nextInt();
        scanner.nextLine();

        LibraryItem item = library.findItemById(idItem);
        Member member = library.findMemberById(idMem);

        library.getLogger().logReturn(item.getTitle(), member.getName());
        System.out.println("✅ " + member.returnItem(item, late));
    }

    private static void handleViewBorrowedItems() {
        System.out.print("ID Member: ");
        String idMem = scanner.next();
        scanner.nextLine();

        Member member = library.findMemberById(idMem);
        member.getBorrowedItems();
    }
}