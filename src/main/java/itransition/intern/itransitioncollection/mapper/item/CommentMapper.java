package itransition.intern.itransitioncollection.mapper.item;

import itransition.intern.itransitioncollection.dtos.item.comment.CommentCreateDto;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentDto;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentUpdateDto;
import itransition.intern.itransitioncollection.entity.item.Comment;
import itransition.intern.itransitioncollection.mapper.base.BaseMapper;
import itransition.intern.itransitioncollection.mapper.base.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Controller;


@Controller
@Mapper(componentModel = "spring")
public interface CommentMapper extends GenericMapper<Comment, CommentDto, CommentCreateDto, CommentUpdateDto>, BaseMapper {


}
