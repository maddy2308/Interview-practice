package practiceProblems;


public class Employee {
    protected long   employeeId;
    protected String firstName;
    protected String lastName;

    public Employee(long employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*@Override
    public boolean equals(Object o){
        if(o == null)                return false;
        if(!(o instanceof Employee)) return false;

        Employee other = (Employee) o;
        return this.employeeId == other.employeeId;
    }*/

    public static void main(String[] args) {
        Employee emp1 = new Employee(123, "John", "Dowe");
        Employee emp2 = new Employee(123, "John", "Baker");
        System.out.println(emp1.hashCode() + " " + emp2.hashCode());
        if (emp1.equals(emp2)) System.out.println("same");
    }
}