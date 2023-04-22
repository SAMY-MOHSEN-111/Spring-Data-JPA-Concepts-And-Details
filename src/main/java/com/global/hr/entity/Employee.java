package com.global.hr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")// not mandatory if same name but to get it stuck in my hand XD
//    @GeneratedValue(strategy = GenerationType.AUTO)// choose based on the dialect

//    choose when dealing with auto increment database
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    sequence supported database
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_sequence")
//    @SequenceGenerator(name = "employee_sequence",sequenceName = "employee_sequence", initialValue = 100, allocationSize = 1)

//    @TableGenerator(name = "employee_sequence",table = "employee_sequence",allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Double salary;

    // many employee have one department
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    //the desired name for the foreign key and the referenced column
    @JsonIgnore// without this annotation it will go on recursive calling for employee and department!
    private Department department;

    public Employee() {
    }

    public Employee(Long id, String name, Double salary, Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
