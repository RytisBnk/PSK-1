package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import java.io.Serializable;
import java.util.concurrent.Future;

public interface RoomNumberGenerator extends Serializable {
    public Future<Integer> generateRoomNumber();
}
