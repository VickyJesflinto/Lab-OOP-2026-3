public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital("12345", "111111");

        System.out.println("ID: " + dompet.getIdNasabah());

        dompet.ubahPin("000000", "222222");
        dompet.ubahPin("111111", "222222");

        dompet.setor(500000);
        dompet.setor(-100);

        dompet.tarik(100000, "111111");
        dompet.tarik(100000, "222222");

        System.out.println("Saldo: " + dompet.getSaldo());
    }
}