package gse.employee;

/**
 * Abstract Employee class.
 *
 * @author Marvin Simon
 */
public abstract class Employee implements IEmployee {

  public Employee(String forename, String surname) {
    if (forename != null && !forename.isBlank()) {
      this.forename = forename;
    } else {
      this.forename = "Jane";
    }
    if (surname != null && !surname.isBlank()) {
      this.surname = surname;
    } else {
      this.surname = "Doe";
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + forename + " " + surname;
  }

}
