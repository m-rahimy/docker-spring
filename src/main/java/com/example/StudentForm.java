package com.example;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentForm extends AbstractComponent {

    private StudentUI studentUI;

    @Autowired
    private StudentRepository studentRepository;

    public StudentForm(StudentUI studentUI) {
        this.studentUI = studentUI;
    }


}
