package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.DTO.AddOfferDto;
import bg.softuni.mobilele.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void addOffer(AddOfferDto addOfferDto) {
        //todo


    }
}
