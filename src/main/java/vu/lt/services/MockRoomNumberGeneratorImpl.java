package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.Future;

@Alternative
public class MockRoomNumberGeneratorImpl implements RoomNumberGenerator {
    @Override
    @Futureable
    public Future<Integer> generateRoomNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(100);
    }
}
