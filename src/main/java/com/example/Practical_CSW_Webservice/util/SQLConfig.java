package com.example.Practical_CSW_Webservice.util;

public class SQLConfig {

    public static final String DATABASE_Employee_INSERT = "insert into employees ( name, salary ) values (?,?)";
    public static final String DATABASE_Employee_SELECT = "select * from employees";
    public static final String DATABASE_Employee_UPDATE = "update employees set name = ?, salary = ? where id = ?";
}
