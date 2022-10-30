package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Comment;
import se331.rest.entity.Comment;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.CommentRepository;

@Repository
public class CommentDaoImpl implements CommentDao{
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Integer getCommentSize() {
        return Math.toIntExact(commentRepository.count());
    }
    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        return commentRepository.findAll(PageRequest.of(page-1,pageSize));
    }
    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }
    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
    @Override
    public Page<Comment> getComments(String name, Pageable pageable) {
        return commentRepository.findByName(name, pageable);

    }

    @Override
    public Page<Comment> getComment(Pageable pageRequest) {
        return commentRepository.findAll(pageRequest);
    }
}
