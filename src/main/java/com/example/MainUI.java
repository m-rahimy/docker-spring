package com.example;


import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI
public class MainUI extends UI {

    private static final long serialVersionUID = 1L;
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button customersButton = new Button("Customers");
        Button personsButton = new Button("Persons");
        horizontalLayout.addComponents(customersButton, personsButton);
        setContent(horizontalLayout);
    }
}
