//package com.global.hr.config;
//
//import com.global.hr.entity.Employee;
//import com.global.hr.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class Startup implements ApplicationRunner, CommandLineRunner {
//    private EmployeeRepository employeeRepository;
//    @Autowired
//    public void wireEmployee(EmployeeRepository employeeRepository){
//        this.employeeRepository = employeeRepository;
//    }
//    @Override
//    public void run(ApplicationArguments args) {
////        employeeRepository.saveAll(List.of(
////                new Employee(null, "samy",1000.0),
////                new Employee(null, "mohsen",2000.0),
////                new Employee(null, "mousa",3000.0),
////                new Employee(null, "abdo",4000.0),
////                new Employee(null, "abo amer",5000.0)
////        ));
//    }
//    // note that CommandLineRunner runs after ApplicationRunner
//    // the below code could be put in the above method, but it is a matter of revision
//    @Override
//    public void run(String... args) throws Exception {
////        System.out.println("-----------------------------------");
////        System.out.println(employeeRepository.findByName("samy"));
////        System.out.println(employeeRepository.filter("oh"));
////        System.out.println(employeeRepository.filterNative("amer"));
//    }
//}
