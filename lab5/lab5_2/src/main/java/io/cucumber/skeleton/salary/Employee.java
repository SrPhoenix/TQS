package io.cucumber.skeleton.salary;

import java.util.Objects;

public class Employee {
	private int id;
	private String user;
	private float salary;
 
    public Employee(int id, String user, float salary) {
        this.id = id;
        this.user = user;
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee id(int id) {
        setId(id);
        return this;
    }

    public Employee user(String user) {
        setUser(user);
        return this;
    }

    public Employee salary(float salary) {
        setSalary(salary);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(user, employee.user) && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, salary);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", salary='" + getSalary() + "'" +
            "}";
    }

}
