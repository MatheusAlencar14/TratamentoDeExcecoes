package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int roomNumber = sc.nextInt();
        System.out.print("Data de check-in: ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de check-Out: ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: A data de chek-out deve ser " +
                    "posterior à data de check-in.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println("Digite os dados para atualizar a reserva: ");
            System.out.print("Check-in: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out: ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Erro na reserva: As datas para atualização da reserva " +
                        "precisam ser datas futuras.");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Erro na reserva: A data de check-out deve ser " +
                        "posterior à data de check-in.");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reserva: " + reservation);
            }
        }
        sc.close();
    }
}
