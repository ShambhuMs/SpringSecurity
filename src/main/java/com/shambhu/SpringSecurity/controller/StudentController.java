package com.shambhu.SpringSecurity.controller;

import com.shambhu.SpringSecurity.dto.StudentDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
    private List<StudentDTO> studentDTOList=new ArrayList<>(List.of(
            new StudentDTO(1,"Shambhu",40),
            new StudentDTO(2,"Nitin",30)));
    @GetMapping("/students")
    public List<StudentDTO> getStudentDTOList(){
        return studentDTOList;
    }
@GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
      return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public StudentDTO getStudentDTOList(@RequestBody StudentDTO studentDTO){
        studentDTOList.add(studentDTO);
        return studentDTO;
    }
}
