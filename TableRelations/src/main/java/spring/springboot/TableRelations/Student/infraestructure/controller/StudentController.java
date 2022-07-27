package spring.springboot.TableRelations.Student.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Student.domain.StudentService;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.FullStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.SimpleStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<SimpleStudentOutputDTO> getAllStudentsRoute(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentByIDRoute(@PathVariable Integer id, @RequestParam(defaultValue = "simple") String outputType){
        try {
            return new ResponseEntity<>(studentService.getStudentByID(id, outputType), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public StudentOutputDTO postStudentRoute(@RequestBody StudentInputDTO studentInputDTO){
        return studentService.postStudent(studentInputDTO);
    }

    @PutMapping("/{id}")
    public StudentEntity updateStudentRoute(@PathVariable Integer id, @RequestBody StudentInputDTO studentInputDTO){
        return studentService.updateStudent(id, studentInputDTO);
    }

    @DeleteMapping("/{id}")
    public StudentEntity deleteStudentRoute(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}
