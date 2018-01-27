package com.example;


import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.Enumeration;
import java.util.Iterator;

@SpringUI
public class MainUI extends UI {

    private static final long serialVersionUID = 1L;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button customersButton = new Button("Customers");
        Button personsButton = new Button("Persons");
        horizontalLayout.addComponents(customersButton, personsButton);

        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(horizontalLayout);

        Enumeration<String> req = vaadinRequest.getAttributeNames();
        while (req.hasMoreElements()){
            String key = req.nextElement();
            layout.addComponent(new Label(String.format("key : %s , \t\t value : %s \n",
                    key, vaadinRequest.getAttribute(key))));
        }


        setContent(layout);
    }
}
