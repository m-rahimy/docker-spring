package com.example;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.List;

@SpringUI(path = "/m-students")
public class StudentUI extends UI {

    @Autowired
    StudentRepository studentRepository;

    private StudentForm studentForm = new StudentForm(this);

    private TextField filterText = new TextField();

    private static final long serialVersionUID = 1L;
    private Grid grid = new Grid();

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout layout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout(grid, studentForm);
        filterText.setInputPrompt("filter by name...");
        filterText.addTextChangeListener(e -> {
            updateList(new Student("", e.getText(), e.getText(),
                    null, e.getText()));

        });

        grid.setColumns("firstName", "lastName", "email");

        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("clear");
        clearFilterTextBtn.addClickListener(e -> {
            filterText.clear();
            updateList(null);
        });

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        layout.addComponent(grid);

        updateList(null);

        layout.setMargin(true);

        setContent(layout);
    }

    public void updateList(Student filter) {
        List<Student> studentList = studentRepository.findAll();

        if (filter != null) {
            studentList = studentRepository.findAll(Example.of(filter));

        }

        grid.setContainerDataSource(new BeanItemContainer<>(Student.class, studentList));
    }
}
