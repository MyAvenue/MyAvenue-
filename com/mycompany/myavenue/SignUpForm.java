/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myavenue;

import Backend.MainSystem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class SignUpForm extends VerticalLayout implements View {
    
    MainSystem main = new MainSystem(); //connect to backend
    
    Label lblTitle;
    Label lblHeader;
    TextField tfID;
    TextField tfName;
    TextField tfEmail;
    TextField tfPhoneNumber;
    PasswordField tfPassword;
    PasswordField tfConfirmPassword;
    DateField dfDOB;
    ComboBox cbType;
    Button btnConfirm;
    Button btnCancel;

    
    public SignUpForm() {
        
        //INITIAL SETUP
        setSpacing(true);
        setMargin(true);
        
        //UI COMPONENTS
        lblTitle = new Label("Sign Up Form");
        lblTitle.addStyleName("h1");
        addComponent(lblTitle);
        
        //Set up form
        FormLayout formLayout = new FormLayout();
        formLayout.setMargin(false);
        formLayout.setWidth("700");
        formLayout.addStyleName("light");
        addComponent(formLayout);
        
        lblHeader = new Label("Personal Information");
        lblHeader.addStyleName("h2");
        lblHeader.addStyleName("colored");
        formLayout.addComponent(lblHeader);
        
        tfID = new TextField("zID");
        //tfID.setRequired(true);
        formLayout.addComponent(tfID);
        
        tfName = new TextField("Name");
        //tfName.setRequired(true);
        formLayout.addComponent(tfName);
        
        tfEmail = new TextField("Email Address");
        //tfName.setRequired(true);
        formLayout.addComponent(tfEmail);
        
        tfPhoneNumber = new TextField("Phone Number");
        //tfName.setRequired(true);
        formLayout.addComponent(tfPhoneNumber);
        
        tfPassword = new PasswordField("Password");
        //tfPassword.setRequired(true);
        formLayout.addComponent(tfPassword);
        
        tfConfirmPassword = new PasswordField("Confirm Password");
        //tfPassword.setRequired(true);
        formLayout.addComponent(tfConfirmPassword);
        
        //Create combobox with arraylist
        ArrayList<String> listType = new ArrayList<>();
        listType.add("Staff");
        listType.add("Student");
       
        
        btnConfirm = new Button("Confirm");
        btnConfirm.addStyleName("primary");
        
        btnConfirm.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event) {
                //sign user up 
                main.signUp(tfID.getValue(), tfName.getValue(), tfPassword.getValue(),tfEmail.getValue(),tfPhoneNumber.getValue());
                
                //show notification
                Notification.show("You signed up successfully!");
                
                //Navigate back to login screen
                getUI().getNavigator().navigateTo("login");
            }
            
            
        });
        
        btnCancel = new Button("Cancel");
        btnCancel.addStyleName("danger");
        
        btnCancel.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event) {
                //Navigate back to login screen
                getUI().getNavigator().navigateTo("login");
            }
        
        });
        
        //Horizontal footer for buttons
        HorizontalLayout footer = new HorizontalLayout();
        footer.setMargin(new MarginInfo(true, false, true, false)); //sets margin for top and bottom
        footer.setSpacing(true);
        footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        formLayout.addComponent(footer);
        footer.addComponent(btnConfirm);
        footer.addComponent(btnCancel);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
