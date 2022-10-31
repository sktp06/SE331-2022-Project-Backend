package se331.rest.controller;

import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Comment;
import se331.rest.entity.CommentDTO;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
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
    ResponseEntity<?> getComments() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(commentService.getAllComments()));
    }
//    @PostMapping("/comment/patient/{id}")
//    ResponseEntity<?> addComment(@PathVariable("id") Long id, @RequestBody Comment comment) {
//        Patient output = patientService.getPatient(id);
//        output.getCommentList().add(comment);
//        Comment outComment = commentService.save(comment);
//        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(outComment));
//    }

    @GetMapping("comment/{id}")
    public ResponseEntity<?> getComment(@PathVariable("id") Long id) {
        Comment output = commentService.getComment(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
    @PostMapping("/comment/patient/{id}")
    ResponseEntity<?> addComment(@PathVariable("id") Long id,@RequestBody Comment comment){
        Patient output_id = patientService.getPatient(id);
        output_id.getCommentList().add(comment);
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
    }
}
