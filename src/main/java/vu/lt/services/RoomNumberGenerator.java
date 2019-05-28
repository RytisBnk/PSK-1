package vu.lt.services;

import java.io.Serializable;
import java.util.concurrent.Future;

public interface RoomNumberGenerator extends Serializable {
    Future<Integer> generateRoomNumber();
}
