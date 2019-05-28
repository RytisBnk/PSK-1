package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.ejb.AsyncResult;
import javax.inject.Inject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Decorator
public class RoomNumberGeneratorDecorator implements RoomNumberGenerator {
    @Inject
    @Delegate
    private RoomNumberGenerator roomNumberGenerator;

    @Override
    @Futureable
    public Future<Integer> generateRoomNumber() {
        Future<Integer> result = roomNumberGenerator.generateRoomNumber();
        System.out.println("Random room number generation has finished");
        return result;
    }
}
