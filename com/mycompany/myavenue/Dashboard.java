/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myavenue;

/**
 *
 * @author Matthew Zhang
 */
import Backend.MainSystem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;


public class Dashboard extends VerticalLayout implements View {
    
    MainSystem main = new MainSystem(); //link to backend
    
    HorizontalLayout upperSection = new HorizontalLayout();
    HorizontalLayout innerUpperSection = new HorizontalLayout();
    HorizontalSplitPanel lowerSection = new HorizontalSplitPanel();
    VerticalLayout menuLayout = new VerticalLayout();
    HorizontalLayout menuTitle = new HorizontalLayout();
    VerticalLayout contentLayout = new VerticalLayout();
    
    Label lblHeader;
    Label lblMenu;
    Button btnLogout;
    
    public Dashboard() {
        
        //UI Components
        
        lblHeader = new Label("");  //will change later
        lblHeader.addStyleName("colored");
        lblHeader.addStyleName("h2");
        lblHeader.setSizeUndefined();
        
        btnLogout = new Button("Sign Out");
        btnLogout.addStyleName("small");
        btnLogout.addStyleName("friendly");
        btnLogout.setSizeUndefined();
        btnLogout.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                //logout using backend
                main.Logout();
                
                //navigate back to login page
                getUI().getNavigator().navigateTo("login");
            }
        });
        
        lblMenu = new Label("Menu");
        lblMenu.addStyleName("colored");
        lblMenu.addStyleName("h2");
        
        //Sections
        innerUpperSection.addComponent(lblHeader);
        innerUpperSection.addComponent(btnLogout);
        innerUpperSection.setExpandRatio(btnLogout, 1);
        innerUpperSection.setSpacing(true);
        innerUpperSection.setComponentAlignment(btnLogout, Alignment.MIDDLE_RIGHT);
        
        upperSection.setSizeFull();
        upperSection.addComponent(innerUpperSection);
        
        upperSection.setMargin(new MarginInfo(false, true, false, false));
        upperSection.setComponentAlignment(innerUpperSection, Alignment.TOP_RIGHT);
        upperSection.addStyleName("borderBottom");
        upperSection.setHeight(4, UNITS_EM);
        
        //menu section
        menuTitle.addComponent(lblMenu);
        menuLayout.addComponent(menuTitle);
        menuLayout.setWidth("100%");
        menuLayout.setComponentAlignment(menuTitle, Alignment.MIDDLE_CENTER);
        
        lowerSection.addComponent(menuLayout);
        lowerSection.addComponent(contentLayout);
        contentLayout.setSizeFull();
        lowerSection.setSizeFull();
        lowerSection.setSplitPosition(15);
        
        addComponent(upperSection);
        addComponent(lowerSection);
        
        setSizeFull();
        
        setExpandRatio(lowerSection,1);
        
        
    }

    public void setMenuTitle() {
        //set the menu title
        menuTitle.addComponent(lblMenu);
        menuLayout.addComponent(menuTitle);
        menuLayout.setWidth("100%");
        menuLayout.setComponentAlignment(menuTitle, Alignment.MIDDLE_CENTER);
        
    }
    
    public void addWelcomeText() {
        //create new label for welcome text
        Label lblTitle = new Label("Welcome " + main.getCurrentUser().getName() + "!");
        lblTitle.addStyleName("h1");
        lblTitle.addStyleName("colored");
        
        lblHeader.setValue("" + main.getCurrentUser().getType());
        
        contentLayout.addComponent(lblTitle);
        contentLayout.setMargin(new MarginInfo(false, false, false, true));

    }
    
    public void addDashboardOption(String caption) {
        //set menu buttons
        
        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);
        
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                contentLayout.removeAllComponents();    //remove everything from the content screen section
                addWelcomeText();
            }
            
        });
    }
    
    /*public Component getComponent(String componentName) {
        if (componentName.equals("GroupForm")) {
            return new GroupForm();
        } else if (componentName.equals("RatingForm")) {
            return new RatingForm();
        } else if (componentName.equals("ClassForm")) {
            return new ClassForm();
        }else { //teacher table
            return new TeacherTable();
        }
    }*/
    
    public void addMenuOption(String caption, String componentName) {
        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                contentLayout.removeAllComponents();
                contentLayout.addComponent(getComponent(componentName));
            }
            
        });
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //reset screen
        menuLayout.removeAllComponents();
        contentLayout.removeAllComponents();
        
        //add components
        setMenuTitle();
        this.addDashboardOption("Dashboard");
        if (main.getCurrentUser().getType().equals("Teacher")){
            this.addMenuOption("Add Class", "ClassForm");
            this.addMenuOption("Show All Reviews", "TeacherTable");
            
        }else{
            this.addMenuOption("Join Group", "GroupForm");
            this.addMenuOption("Review Team", "RatingForm");
        }
        
        addWelcomeText();
    }
}
