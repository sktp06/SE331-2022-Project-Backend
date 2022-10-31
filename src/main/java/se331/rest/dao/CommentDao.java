package se331.rest.dao;

import org.checkerframework.checker.units.qual.C;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Comment;
import se331.rest.entity.Doctor;

public interface CommentDao {
    Comment save (Comment comment);
    Page<Comment> getComment(Pageable pageRequest);
    Comment getComment(Long id);


}
