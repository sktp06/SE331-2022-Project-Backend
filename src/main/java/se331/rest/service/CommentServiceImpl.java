package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.dao.CommentDao;
import se331.rest.dao.CommentDao;
import se331.rest.entity.Comment;
import se331.rest.entity.Comment;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    public Integer getCommentSize() {
        return commentDao.getCommentSize();
    }

    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        return commentDao.getComments(pageSize, page);
    }

    @Override
    public Comment getComment(Long id) {
        return commentDao.getComment(id);
    }

    @Override
    @Transactional
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Page<Comment> getComments(String name, Pageable pageable) {
        return commentDao.getComments(name,pageable);
    }
    @Override
    public List<Comment> getAllComments() {
        return commentDao.getComment(Pageable.unpaged()).getContent();
    }
}
