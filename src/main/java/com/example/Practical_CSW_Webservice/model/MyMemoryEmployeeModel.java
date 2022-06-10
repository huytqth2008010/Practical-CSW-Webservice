package com.example.Practical_CSW_Webservice.model;

import com.example.Practical_CSW_Webservice.entity.Employee;
import com.example.Practical_CSW_Webservice.util.ConnectionHelper;
import com.example.Practical_CSW_Webservice.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyMemoryEmployeeModel implements EmployeeModel {
    @Override
    public List<Employee> getEmployees() {
        List<Employee> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.DATABASE_Employee_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                Employee obj = new Employee(id, name, salary);
                listObj.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public boolean addEmployees(Employee e) {
        try
        {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.DATABASE_Employee_INSERT);
            preparedStatement.setString(1, e.getName());
            preparedStatement.setDouble(2, e.getSalary());
            preparedStatement.execute();
            return true;
        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee e, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_Employee_UPDATE);
            statement.setString(1, e.getName());
            statement.setDouble(2, e.getSalary());
            statement.setInt(3, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
        return false;
    }
}
