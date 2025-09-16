import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Person {
	public String name;
	public String surname;
	public String fullName;
	public Date birthDate;
	public boolean anotherCompanyOwner;
	public boolean pensioner;
	public boolean publicServer;
	public float salary;

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.fullName = this.name + " " + this.surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public String getFullName() {
    	return this.fullName;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return this.salary * 12;
    }

    public int getAge() {
        LocalDate birth = this.birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public boolean isMEI() {
        return this.calculateYearlySalary() < 130000 &&
               this.getAge() >= 18 &&
               !this.anotherCompanyOwner &&
               !this.pensioner &&
               !this.publicServer;
    }
}