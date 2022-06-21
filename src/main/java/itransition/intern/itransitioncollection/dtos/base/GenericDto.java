package itransition.intern.itransitioncollection.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public abstract class GenericDto implements BaseDto {

    private Long id;

}
