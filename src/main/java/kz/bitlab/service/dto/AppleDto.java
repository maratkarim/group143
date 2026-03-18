package kz.bitlab.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AppleDto {
    private Long idDto;

    private String nameDto;

    private String descriptionDto;

    private int priceDto;
}
