package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.DTO.AddOfferDto;
import bg.softuni.mobilele.model.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDto addOfferDto);
}
