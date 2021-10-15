package gse.employee;

/**
 * Abstract Employee class.
 *
 * @author Marvin Simon
 */
public abstract class Employee {

  protected String surname;
  protected String forename;
  protected float yearlySalaryToThisDate;

  /**
   * Main method of the program.
   *
   * @param args Command Line Arguments
   */
  public static void main(String[] args) {
    SalariedEmployee sergej = new SalariedEmployee("Sergej", "Bakanov", 3550, 0.5f, 35);
    System.out.println(sergej);
    sergej.setHoursWorkedOvertime(50);
    System.out.println(sergej.calculateSalary());
  }

  public Employee(String forename, String surname) {
    if (forename != null || !forename.isBlank()) {
      this.forename = forename;
    } else {
      this.forename = "Jane";
    }
    if (forename != null || !forename.isBlank()) {
      this.surname = surname;
    } else {
      this.surname = "Doe";
    }
  }

  /**
   * Getter for the forename.
   *
   * @return Forename of the employee
   */
  public String getForename() {
    return forename;
  }

  /**
   * Getter SummedUpSalary.
   *
   * @return Summed up salary to this day
   */
  public float getYearlySalaryToThisDate() {
    return yearlySalaryToThisDate;
  }

  /**
   * Getter for the surname.
   *
   * @return Surname of the employee
   */
  public String getSurname() {
    return surname;
  }

  @Override
  public String toString() {
    return forename + " " + surname;
  }

  public abstract float calculateSalary();
}
