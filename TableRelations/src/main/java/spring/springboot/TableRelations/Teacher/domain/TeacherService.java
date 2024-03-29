package spring.springboot.TableRelations.Teacher.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Person.infraestructure.repository.jpa.PersonRepository;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Student.infraestructure.repository.StudentRepository;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;
import spring.springboot.TableRelations.Teacher.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherInterface{

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<TeacherOutputDTO> getAllTeachers() {
        List<TeacherOutputDTO> teacherOutputDTOList = new ArrayList<>();
        for(TeacherEntity teacherEntity : teacherRepository.findAll()){
            teacherOutputDTOList.add(new TeacherOutputDTO(teacherEntity));
        }
        return teacherOutputDTOList;
    }

    @Override
    public TeacherOutputDTO getTeacherByID(Integer id) {
        if(!teacherRepository.existsById(id))
            throw new RuntimeException("Teacher with id: " + id + " doesnt exists.");

        TeacherOutputDTO teacherOutputDTO = new TeacherOutputDTO(teacherRepository.findById(id).orElse(null));
        return teacherOutputDTO;
    }

    @Override
    public TeacherOutputDTO postTeacher(TeacherInputDTO teacherInputDTO) throws  RuntimeException{
        PersonEntity personEntity = personRepository.findById(teacherInputDTO.getPersonID()).orElse(null);

        if(personEntity==null ||
                teacherRepository.getPersonQuery(teacherInputDTO.getPersonID()) != null ||
                studentRepository.getPersonQuery(teacherInputDTO.getPersonID()) != null
        )
            throw new RuntimeException("Teacher object must have a correct person reference.");

        TeacherEntity teacherEntity = new TeacherEntity(teacherInputDTO, personEntity);
        teacherRepository.save(teacherEntity);

        return new TeacherOutputDTO(teacherEntity);
    }
}
