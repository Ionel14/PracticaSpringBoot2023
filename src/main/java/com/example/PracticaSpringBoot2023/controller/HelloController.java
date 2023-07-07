package com.example.PracticaSpringBoot2023.controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/sayHello")
    @ResponseBody
    public String printHello()
    {
        return "Hello World";
    }

    @GetMapping(value = "/register")
    @ResponseBody
    public String printParams(@RequestParam String name, @RequestParam String firstname)
    {
        return "Hello, " + firstname + " " + name;
    }

    @GetMapping(value = "/magazin/{location}/products")
    @ResponseBody
    public String printPathVariables(@PathVariable String location)
    {
        return "Showing products for " + location;
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<Employee> listEmployees()
    {
        Employee e1 = new Employee(1,"Giany", 3000);
        Employee e2 = new Employee(2,"Gianina", 2900);



        return List.of(e1,e2);
    }

    @GetMapping(value = "/index")
    public String index(Model model)
    {
        String text = "hello";
        model.addAttribute("greetings", text);
        model.addAttribute("wew", "Goodbye");

        List<String> cars = List.of("Dacia", "Ford", "BMW", "Suzuki");
        model.addAttribute("cars", cars);

        Employee e1 = new Employee(1,"Giany", 3000);
        Employee e2 = new Employee(2,"Gianina", 2900);

        List<Employee> employees = List.of(e1,e2);
        model.addAttribute("employees", employees);

        return "index";
    }
}
