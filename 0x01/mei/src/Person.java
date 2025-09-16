import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
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

	public void setPensioner(boolean pensioner) {
		this.pensioner = pensioner;
	}

	public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
		this.anotherCompanyOwner = anotherCompanyOwner;
	}

	public void setPublicServer(boolean publicServer) {
		this.publicServer = publicServer;
	}
}