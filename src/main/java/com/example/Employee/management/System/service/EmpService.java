package com.example.Employee.management.System.service;

import com.example.Employee.management.System.entity.Employee;
import com.example.Employee.management.System.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {


     @Autowired
     private EmpRepo empRepo;


     public List<Employee> getAllEmp() {
          return empRepo.findAll();
     }

     public void addemp(Employee employee) {
          empRepo.save(employee);
     }

     public Employee getEmpById(int id) {

          Optional<Employee> e = empRepo.findById(id);
          if (e.isPresent()) {
               return e.get();

          } else {
               return null;
          }
     }

     public void deleteEmp(int id) {
          empRepo.deleteById(id);

     }


}
