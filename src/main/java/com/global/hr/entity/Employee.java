package com.global.hr.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@NamedQuery(
        name = "Employee.findBySalary",
        query = "select employee from Employee employee where employee.salary >= :salary"
)/* I don't think this is a good place to write queries, I prefer to write them in Repository instead.
    This is matter of single responsibility*/

//@SqlResultSetMapping(
//        name = "employeeMapping",
//        entities = @EntityResult(
//                entityClass = Employee.class,
//                fields = {
//                        @FieldResult(name = "id",column = "id"),
//                        @FieldResult(name = "name",column = "name"),
//                        @FieldResult(name = "salary",column = "salary"),
//
//                }
//        )
//)
//@NamedNativeQuery(
//        name = "findByDepartmentId",
//        query = "select id,name,salary from `hr-global`.employee where employee.account_id = :id",
//        resultSetMapping = "employeeMapping"
//)

@Table(name = "employee")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    @Id
    @Column(name = "id")// not mandatory if same name but to get it stuck in my hand XD
//    @GeneratedValue(strategy = GenerationType.AUTO)// choose based on the dialect

//    choose when dealing with auto increment database
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
    //@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    //the desired name for the foreign key and the referenced column
    //@JsonIgnore// without this annotation it will go on recursive calling for employee and department!
    private Department department;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Employee() {
    }

    public Employee(Long id, String name, Double salary/*, Department department, Account account*/) {
        this.id = id;
        this.name = name;
        this.salary = salary;
//        this.department = department;
//        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
