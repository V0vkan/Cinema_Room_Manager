package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();

        Room room = new Room(rows, seatsInRow);
        Utils utils = new Utils();

        boolean flag = true;
        while (flag) {
            utils.printMenu();
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    utils.printRoom(room.getRoom());
                    break;
                case 2:
                    utils.buyTicket(room.getRoom());
                    break;
                case 3:
                    utils.printStatistics(rows, seatsInRow);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }

}