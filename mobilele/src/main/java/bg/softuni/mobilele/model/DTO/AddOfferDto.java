package bg.softuni.mobilele.model.DTO;

import bg.softuni.mobilele.model.enums.EngineEnum;
import bg.softuni.mobilele.model.enums.TransmissionEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddOfferDto {

    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    @NotEmpty
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

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
