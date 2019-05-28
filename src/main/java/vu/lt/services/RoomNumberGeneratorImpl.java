package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;
import vu.lt.interceptors.LoggedInvocation;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
public class RoomNumberGeneratorImpl implements RoomNumberGenerator {
    @Futureable
    @LoggedInvocation
    @Override
    public Future<Integer> generateRoomNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        Integer generatedNumber = new Random().nextInt(100);
        System.out.println("Done");
        return new AsyncResult<>(generatedNumber);
    }
}
