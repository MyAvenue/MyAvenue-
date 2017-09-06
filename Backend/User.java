/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.util.Date;

//superclass fo teacher, student
public class User {

    protected String zID;
    protected String name;
    protected String password;
    protected String email;
    protected String phoneNumber;
    protected Date DOB;
    protected String gender;

    public User(String zID, String name, String password, String email, String phoneNumber) {
        this.zID = zID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getID() {
        return this.zID;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String phoneNumber() {
        return this.phoneNumber;
    }
    
    public Date getDOB() {
        return this.DOB;
    }


    public String getType() {
        return "";
    }

    //can only be called by Teacher
    public ArrayList<Class> getClasses() {
        return new ArrayList<>();
    }

    public void addClass(Class class1) {
        //leave blank
    }

    public void addClassToTeacher(String classID, String name) {
        //leave blank
    }

    @Override
    public String toString() {
        return this.zID + ": " + this.name;
    }
}
