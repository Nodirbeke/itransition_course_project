package itransition.intern.itransitioncollection.service.item;

import itransition.intern.itransitioncollection.dtos.item.comment.CommentCreateDto;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentDto;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentUpdateDto;
import itransition.intern.itransitioncollection.mapper.item.CommentMapper;
import itransition.intern.itransitioncollection.repository.item.CommentRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends AbstractService<CommentRepository, CommentMapper>
        implements GenericCrudService<CommentDto, CommentCreateDto, CommentUpdateDto, Long>, BaseService {

    public CommentService(CommentRepository repository,
                          CommentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(CommentCreateDto createDto) {
        return null;
    }

    @Override
    public Long update(CommentUpdateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public CommentDto get(Long id) {
        return null;
    }

    @Override
    public List<CommentDto> getAll() {
        return null;
    }
}
