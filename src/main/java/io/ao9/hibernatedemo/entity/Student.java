package io.ao9.hibernatedemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "student")
public class Student{
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "first_name")
    private String firstName
    
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    public Student(){
        
    }
    
    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
