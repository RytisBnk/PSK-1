package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.inject.Specializes;
import java.util.Random;
import java.util.concurrent.Future;

@Specializes
public class RoomNumberGeneratorSpecialized extends RoomNumberGeneratorImpl {
    @Override
    @Futureable
    public Future<Integer> generateRoomNumber() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(200 + (new Random().nextInt(100)));
    }
}
