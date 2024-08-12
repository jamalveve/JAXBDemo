package com.jaxb.my_jaxb_project;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;

import com.jaxb.conevertto.Address;
import com.jaxb.conevertto.Employee;
import com.jaxb.xml.JAXBXMLHandler;
 
public class JAXBDemo {
    public static void main(String[] args) {
 
        Address address = new Address();
        address.setStreet("2163, 1st Avenue");
        address.setCity("Peoria");
        address.setState("Illinois");
        address.setZip(61606);
         
        Employee employee = new Employee(1, "Kumar", "Development", address);
         
        try {
            //Marshalling: Writing Java object to XML file
            JAXBXMLHandler.marshal(employee, new File("employee.xml"));
         
            //Unmarshalling: Converting XML content to Java objects
            Employee employee2 = JAXBXMLHandler.unmarshal(new File("employee.xml"));
            System.out.println(employee2);  
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }       
    }
}
