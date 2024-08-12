package com.jaxb.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.jaxb.to.Employee;

 
public class JAXBXMLHandler {
 
    // Export: Marshalling
    public static void marshal(com.jaxb.to.Employee employee, File selectedFile)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(com.jaxb.to.Employee.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(employee, writer);
        writer.close();
    }
 
    // Import: Unmarshalling
    public static Employee unmarshal(File importFile) throws JAXBException {
        Employee employee = null;
        JAXBContext context;
 
        context = JAXBContext.newInstance(Employee.class);
        Unmarshaller um = context.createUnmarshaller();
        employee = (Employee) um.unmarshal(importFile);
 
        return employee;
    }
}
