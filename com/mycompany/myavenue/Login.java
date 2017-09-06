/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myavenue;

import Backend.MainSystem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.Date;

/**
 *
 * @author jamesdgabb
 */
public class Login extends VerticalLayout implements View {
    
    MainSystem main = new MainSystem(); //link to backend
    
    TextField tfID;
    PasswordField tfPassword;
    Button btnSignUp;
    Button btnLogin;
    
    public Login(){

        //UI Elements
        tfID = new TextField("zID");
        tfPassword = new PasswordField("Password");
        
        //Add horizontal layout for buttons
        HorizontalLayout HLayout = new HorizontalLayout();
        
        //HARDCODE LOGIN -- **REMOVE LATER **
       
        main.signUp("z1", "John Smith", "12345", "zyz@gmail.com", "12345");
        main.signUp("z3", "Bob Willis", "12345", "12345", "12345");
        main.signUp("z2", "Michael Cahalane", "12345", "12345","12345");
        
        //UI Elements - Buttons
        btnLogin = new Button("Login");
        btnLogin.addStyleName("friendly");
        
        //Login Navigation
        btnLogin.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (main.Login(tfID.getValue(), tfPassword.getValue())) {
                    //logged in successfully
                    getUI().getNavigator().navigateTo("dashboard");
                    
                    //reset UI Components
                    tfID.setValue("");
                    tfPassword.setValue("");
                }else {
                    //incorrect login notification
                    Notification.show("Incorrect Login Details!", Notification.Type.ERROR_MESSAGE);
                }
            }
            
        });
        
        btnSignUp = new Button("Sign Up");
        btnSignUp.addStyleName("primary");
        
        //Navigation
        btnSignUp.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo("signup");
                
                //reset UI Components
                tfID.setValue("");
                tfPassword.setValue("");
            }
        });
        
        HLayout.addComponent(btnLogin);
        HLayout.addComponent(btnSignUp);
        
        HLayout.setSpacing(true);
        
        //Form Layout
        FormLayout formLayout = new FormLayout(tfID, tfPassword, HLayout);
        formLayout.setMargin(true);
        
        //Panel
        Panel loginPanel = new Panel("Login Page", formLayout);
        loginPanel.setWidth("450");
        loginPanel.setHeight("250");
        
        
        //Add Components
        addComponent(loginPanel);
        setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        setHeight("100%");
        
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
       
    }
}
