package com.example.Practical_CSW_Webservice.resource;


import com.example.Practical_CSW_Webservice.entity.Employee;
import com.example.Practical_CSW_Webservice.model.EmployeeModel;
import com.example.Practical_CSW_Webservice.model.MyMemoryEmployeeModel;

import javax.ws.rs.*;
import java.util.List;

@Path("/employees")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeResource {
    EmployeeModel employeeModel;

    public EmployeeResource(){
        employeeModel = new MyMemoryEmployeeModel();
    }

    @GET
    public List<Employee> fillAll(){
        return employeeModel.getEmployees();
    }

    @POST
    public boolean addEmployees(Employee employee){
        return employeeModel.addEmployees(employee);
    }

    @PUT
    @Path("{id}")
    public boolean updateEmployee(@PathParam("id") int id, Employee updateEmployee){
        return employeeModel.updateEmployee(updateEmployee, id);
    }

}
