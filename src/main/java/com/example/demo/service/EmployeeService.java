package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findByNameLastName(String name, String lastName) {
        return employeeRepository.findByNameAndLastName(name, lastName);
    }

    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByNameLike(name);
    }

    public void delete(Long id) {
        Employee employee = employeeRepository.getOne(id);
        employeeRepository.delete(employee);
    }

    @Scheduled(cron = "0 49 18 * * *")
    public Employee saveSchedule() {
        Employee employee1 = new Employee();
        employee1.setName("sssss");
        employee1.setLastName("aaaaaa");
        return employeeRepository.save(employee1);
    }
}
