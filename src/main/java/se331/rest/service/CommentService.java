package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Comment;
import se331.rest.entity.Comment;

import java.util.List;

public interface CommentService {
    Integer getCommentSize();
    Page<Comment> getComments(Integer pageSize, Integer page);
    Comment getComment(Long id);
    Comment save(Comment comment);
    Page<Comment> getComments(String name, Pageable pageable);

    List<Comment> getAllComments();
}
