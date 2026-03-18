package kz.bitlab.service.service;

import kz.bitlab.service.dto.AppleDto;
import kz.bitlab.service.mapper.AppleMapper;
import kz.bitlab.service.model.AppleProduct;
import kz.bitlab.service.repository.AppleProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class AppleService {
    private final "";
    private final AppleProductRepository appleProductRepository;
    private final AppleMapper appleMapper;

    public AppleService(AppleProductRepository appleProductRepository, AppleMapper appleMapper) {
        this.appleProductRepository = appleProductRepository;
        this.appleMapper = appleMapper;
    }

    public List<AppleDto> getAll(){
        List<AppleProduct> appleProducts = appleProductRepository.findAll();
        List<AppleDto> appleDtosDtoList = appleMapper.toDtoList(appleProducts);
        return appleDtosDtoList;

    }


    public AppleDto getById(Long id){
        AppleProduct appleDto = appleProductRepository.findById(id).orElse(null);

        if(Objects.isNull(appleDto)){
            return null;
        }

        AppleDto dto = appleMapper.toDto(appleDto);
        return dto;

    }

    public AppleDto addApple(AppleDto appleDto){
        AppleProduct appleProduct1 = appleMapper.toEntity(appleDto);
        AppleProduct createdApple = appleProductRepository.save(appleProduct1);
        AppleDto createdTyreDto = appleMapper.toDto(createdApple);
        return appleDto;


    }

    public AppleProduct updateApple (Long id ,AppleProduct  appleProduct){



        AppleDto checkAppleProduct = getById(id);

        if(Objects.isNull(checkAppleProduct)){
            return null;
        }

//        AppleDto appleDto = appleMapper.toEntity(appledto);
//        AppleDto updatedApple = appleRepository.save(appleProduct);
//        AppleDto updatedTyreDto = appleMapper.toDto(updatedApple);
//        return updatedAppleDto;

        appleProduct.setId(appleProduct.getId());
        appleProduct.setName(appleProduct.getName());
        appleProduct.setDescription(appleProduct.getDescription());
        appleProduct.setPrice(appleProduct.getPrice());
        return  appleProductRepository.save(appleProduct);
    }

    public void deleteApple(Long id){
        appleProductRepository.deleteById(id);
    }




}
