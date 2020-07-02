//package com.mhacar.managedBeans;
//
//import com.mhacar.entity.Student;
//import com.mhacar.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.context.annotation.SessionScope;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
//
//@ManagedBean(name = "studentBean")
//@RequestScoped
//public class StudentManagedBeans{
//
//    @ManagedProperty(value = "#{studentService}")
//    transient StudentService studentService;
//
//    private String firstName;
//
//    private String lastName;
//
//
//    public StudentManagedBeans() {
//    }
//
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//
//    public void addStudent() {
//
//        try{
//            Student theStudent = new Student();
//            theStudent.setFirstName(firstName);
//            theStudent.setLastName(lastName);
//
//            studentService.addStudent(theStudent);
//        }catch (Exception e){
//            System.out.println("addStudent() Error. " + e.getMessage());
//            e.printStackTrace();
//        }
//
//    }
//
//
//}
