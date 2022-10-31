package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Comment;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.service.PatientService;
import se331.rest.service.VaccineService;
import se331.rest.util.LabMapper;

@Controller
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @Autowired
    PatientService patientService;

    @GetMapping("/vaccine")
    ResponseEntity<?> getVaccines() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(vaccineService.getAllVaccines()));
    }
    @GetMapping("vaccine/{id}")
    public ResponseEntity<?> getVaccine(@PathVariable("id") Long id) {
        Vaccine output = vaccineService.getVaccine(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/vaccine/patient/{id}")
    ResponseEntity<?> addVaccine(@PathVariable("id") Long id,@RequestBody Vaccine vaccine){
        Patient output_id = patientService.getPatient(id);
        output_id.getVaccineList().add(vaccine);
        Vaccine output = vaccineService.save(vaccine);
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(output));
    }



}
