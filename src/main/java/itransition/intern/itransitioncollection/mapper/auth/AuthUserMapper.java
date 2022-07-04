package itransition.intern.itransitioncollection.mapper.auth;

import itransition.intern.itransitioncollection.dtos.auth.AuthUserCreateDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserUpdateDto;
import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import itransition.intern.itransitioncollection.mapper.base.BaseMapper;
import itransition.intern.itransitioncollection.mapper.base.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthUserMapper extends GenericMapper<AuthUser, AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto>, BaseMapper {

   }
