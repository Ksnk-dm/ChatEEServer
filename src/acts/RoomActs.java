package acts;

import utils.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomActs {
    private static final RoomActs rooms = new RoomActs();
    private final List<Room> chatRooms = new ArrayList<Room>();
    public static RoomActs getInstance() {
        return rooms;
    }

    private RoomActs() {
        chatRooms.add(new Room("home"));
    }

    public Room getRoom(String name) {
        Room room = null;
        for (Room chr : chatRooms) {
            if (chr.getName().equals(name)) {
                room = chr;
                break;
            }
        }
        return room;
    }



}

