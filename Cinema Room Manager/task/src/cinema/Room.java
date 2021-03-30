package cinema;

import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class Room {
    private char[][] room;

    public Room(int rows, int seatsInRow) {
        room = new char[rows][seatsInRow];
        for (char[] chars : room) {
            Arrays.fill(chars, 'S');
        }
    }

    public char[][] getRoom() {
        return room;
    }

}
