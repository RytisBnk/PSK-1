package vu.lt.usecases;

import vu.lt.interceptors.LoggedInvocation;
import vu.lt.services.RoomNumberGenerator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class GenerateRandomRoomNumber implements Serializable {
    @Inject
    private RoomNumberGenerator roomNumberGenerator;

    private Future<Integer> roomNumberGenerationTask = null;

    @LoggedInvocation
    public String generateNewRoomNumber() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        roomNumberGenerationTask = roomNumberGenerator.generateRoomNumber();
        return  "/roomDetails.xhtml?faces-redirect=true&roomId=" + requestParams.get("roomId");
    }

    public boolean isGeneratorRunning() {
        return roomNumberGenerationTask != null  && !roomNumberGenerationTask.isDone();
    }

    @LoggedInvocation
    public String getGenerationStatus() throws ExecutionException, InterruptedException {
        if (roomNumberGenerationTask == null) {
            return null;
        }
        else if (isGeneratorRunning()) {
            return "Room number generation is in progress";
        }
        return "Generated room number: " + roomNumberGenerationTask.get();
    }
}
