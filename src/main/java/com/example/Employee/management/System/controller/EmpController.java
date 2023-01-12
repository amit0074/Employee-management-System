package com.example.Employee.management.System.controller;

import com.example.Employee.management.System.entity.Employee;
import com.example.Employee.management.System.repository.EmpRepo;
import com.example.Employee.management.System.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;


    @GetMapping("/")
    public String home(Model m)
    {
        List<Employee> emp=service.getAllEmp();
        m.addAttribute("emp",emp);
        return "index";
    }




    @GetMapping("/addemp")
    public String addEmp()
    {
        return "addEmp";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Employee employee){

        System.out.println(employee);
        service.addemp(employee);
//        session.setAttribute("msg","Employee saved successfully...");

      return "redirect:/";


    }

    @GetMapping("/edit/{id}")
        public String edit(@PathVariable int id, Model m){

        Employee e=service.getEmpById(id);
        m.addAttribute("emp",e);
        return "edit";
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e){

        service.addemp(e);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id){
        service.deleteEmp(id);
        return "redirect:/";
    }



}
