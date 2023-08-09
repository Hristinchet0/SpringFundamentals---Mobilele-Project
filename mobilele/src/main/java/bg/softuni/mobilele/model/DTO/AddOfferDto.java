package bg.softuni.mobilele.model.DTO;

import bg.softuni.mobilele.model.enums.EngineEnum;
import bg.softuni.mobilele.model.enums.TransmissionEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddOfferDto {

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    @NotEmpty
    private String imageUrl;

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }
}
