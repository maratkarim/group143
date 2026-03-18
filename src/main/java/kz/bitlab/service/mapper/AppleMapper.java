package kz.bitlab.service.mapper;

import kz.bitlab.service.dto.AppleDto;
import kz.bitlab.service.model.AppleProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppleMapper {

    @Mapping(source = "name", target = "nameDto")
    @Mapping(source = "description", target = "descriptionDto")
    @Mapping(source = "price", target = "priceDto")
    AppleDto toDto(AppleProduct appleProduct);

    @Mapping(source = "nameDto", target = "name")
    @Mapping(source = "descriptionDto", target = "description")
    @Mapping(source = "priceDto", target = "price")
    AppleProduct toEntity(AppleDto appleDto);

    List<AppleDto> toDtoList(List<AppleProduct> appleProductList);


}




