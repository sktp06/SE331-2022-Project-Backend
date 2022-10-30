package se331.rest.controller;

import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se331.rest.entity.Comment;
import se331.rest.entity.CommentDTO;
import se331.rest.entity.Patient;
import se331.rest.entity.Comment;
import se331.rest.service.CommentService;
import se331.rest.service.PatientService;
import se331.rest.util.LabMapper;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    PatientService patientService;
    @GetMapping("/comment")
    public ResponseEntity<?> getcomments(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Comment> pageOutput;
        if (title == null) {
            pageOutput = commentService.getComments(perPage, page);
        } else {
            pageOutput = commentService.getComments(title, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getCommentDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);


    }
    @PostMapping("/comment/patient/{id}")
    ResponseEntity<?> addComment(@PathVariable("id") Long id, @RequestBody Comment comment) {
        Patient output = patientService.getPatient(id);
        output.getCommentList().add(comment);
        Comment outComment = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(outComment));
    }
}
