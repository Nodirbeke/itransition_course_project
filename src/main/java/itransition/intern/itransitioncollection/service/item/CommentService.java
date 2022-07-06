package itransition.intern.itransitioncollection.service.item;

import itransition.intern.itransitioncollection.dtos.item.comment.CommentCreateDto;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentDto;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentUpdateDto;
import itransition.intern.itransitioncollection.entity.item.Comment;
import itransition.intern.itransitioncollection.exception.NotFoundException;
import itransition.intern.itransitioncollection.mapper.item.CommentMapper;
import itransition.intern.itransitioncollection.repository.item.CommentRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService extends AbstractService<CommentRepository, CommentMapper>
        implements GenericCrudService<CommentDto, CommentCreateDto, CommentUpdateDto, Long>, BaseService {

    public CommentService(CommentRepository repository,
                          CommentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(CommentCreateDto createDto) {
        Comment comment = mapper.fromCreatDto(createDto);
        Comment save = repository.save(comment);
        return save.getId();
    }

    @Override
    public Long update(CommentUpdateDto updateDto) {
        Comment target = checkExistenceAndGetById(updateDto.getId());
        Comment comment = mapper.fromUpdateDto(updateDto, target);
        Comment save = repository.save(comment);
        return save.getId();
    }

    private Comment checkExistenceAndGetById(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Void delete(Long id) {
        checkExistenceAndGetById(id);
        repository.softDeleteById(id);
        return null;
    }

    @Override
    public CommentDto get(Long id) {
        Comment comment = checkExistenceAndGetById(id);
        return mapper.toDto(comment);
    }

    @Override
    public List<CommentDto> getAll() {
        return null;
    }

    @Override
    public List<CommentDto> getAll(Long id) {
        List<Comment> comments = repository.findAllByItemId(id);
        return mapper.toDto(comments);
    }
}
