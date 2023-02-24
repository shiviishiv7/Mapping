package com.example.mapping.service;


import com.example.mapping.dto.LaptopDto;
import com.example.mapping.exception.RecordNotFound;
import com.example.mapping.model.Laptop;
import com.example.mapping.model.Student;
import com.example.mapping.repo.LaptopRepo;
import com.example.mapping.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;

    public Laptop addLaptop(LaptopDto laptopDto) throws RecordNotFound {
        Student byStudent = studentService.findByStudent(laptopDto.getStudentID());
        Laptop Laptop = new Laptop();
        String ID = UUID.randomUUID().toString();

        Laptop.setID(ID);
        Laptop.setName(laptopDto.getName());
        Laptop.setBrand(laptopDto.getBrand());
//        Laptop.se(byStudent);
        Laptop.setPrice(laptopDto.getPrice());

        byStudent.setLaptop(Laptop);

//        Laptop __Laptop = laptopRepo.save(Laptop);
        Student save = studentRepo.save(byStudent);
        return save.getLaptop();
    }

    public Laptop findByLaptop(String laptopId) throws RecordNotFound {
        Optional<Laptop> LaptopOptional = laptopRepo.findById(laptopId);

        if(LaptopOptional.isPresent())
            return LaptopOptional.get();
        throw new RecordNotFound("Laptop Not Found By Id "+laptopId);

    }

    public List<Laptop> findAllLaptop() {
        List<Laptop> LaptopRepoAll = laptopRepo.findAll();
        return LaptopRepoAll;
    }
}

