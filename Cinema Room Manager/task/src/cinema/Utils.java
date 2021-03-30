package cinema;

import java.util.Scanner;

public class Utils {
    Scanner scanner = new Scanner(System.in);
    private int totalPurchasedTickets = 0;
    private int currentIncome = 0;

    @SuppressWarnings("unused")
    public int calculateTotalIncome(int rows, int seatsInRow) {
        int totalIn;
        if (rows * seatsInRow <= 60) {
            totalIn = rows * seatsInRow * 10;
        } else {
            if (rows % 2 == 0) {
                totalIn = ((rows / 2) * seatsInRow * 10) + ((rows / 2) * seatsInRow * 8);
            } else {
                totalIn = ((rows / 2) * seatsInRow * 10) + ((rows / 2 + 1) * seatsInRow * 8);
            }
        }
        return totalIn;
    }

    public double calculatePurchasedTicketsPercentage(int rows, int seatsInRow) {
        int totalSeats = rows * seatsInRow;
        return (double) totalPurchasedTickets / totalSeats * 100;
    }

    public void printStatistics(int rows, int seatsInRow) {
        System.out.println("\nNumber of purchased tickets: " + totalPurchasedTickets);
        System.out.printf("Percentage: %.2f", calculatePurchasedTicketsPercentage(rows, seatsInRow));
        System.out.print("%\n");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + calculateTotalIncome(rows, seatsInRow));
    }

    public void buyTicket(char[][] room) {
        int rowNum;
        int seatNum;
        while (true) {
            System.out.println("\nEnter a row number:");
            rowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNum = scanner.nextInt();
            if (rowNum > room.length | seatNum > room[0].length) {
                System.out.println("\nWrong input!");
            } else if (room[rowNum - 1][seatNum - 1] == 'B') {
                System.out.println("\nThat ticket has already been purchased!");
            } else {
                break;
            }
        }


        int ticketPrice;
        if (room.length * room[0].length <= 60) {
            ticketPrice = 10;
        } else {
            if (rowNum <= room.length / 2) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }

        room[rowNum - 1][seatNum - 1] = 'B';
        totalPurchasedTickets++;
        currentIncome += ticketPrice;
        System.out.println("\nTicket price: $" + ticketPrice);
    }

    public void printRoom(char[][] room) {
        System.out.println("\nCinema:");
        int rowsCounter = 1;
        int seatsCounter = 1;
        for (int i = 0; i < room.length; i++) {
            if (i == 0) {
                System.out.print(" ");
                for (int j = 0; j < room[i].length; j++) {
                    System.out.print(" " + seatsCounter++);
                }
                System.out.println();
            }
            System.out.print(rowsCounter++);
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(" " + room[i][j]);
            }
            System.out.println();
        }
    }

    public void printMenu() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

}
