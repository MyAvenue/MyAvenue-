/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.util.Date;

public class Student extends User {

    public Student(String zID, String name, String password, String email, String phoneNumber) {
        super(zID, name, password, email, phoneNumber);
    }
    
    
    public String getType() {
        return "Student";
    }
}
