package gse.employee;

public abstract class Employee {

  protected String surname;
  protected String forename;
  protected float yearlySalaryToThisDate;

  public static void main(String[] args) {

  }

  public Employee(String surname, String forename) {
    this.surname = surname;
    this.forename = forename;
  }

  /**
   * Getter for the forename.
   * @return Forename of the employee
   */
  public String getForename() {
    return forename;
  }

  /**
   * Getter SummedUpSalary.
   * @return Summed up salary to this day
   */
  public float getYearlySalaryToThisDate() {
    return yearlySalaryToThisDate;
  }

  /**
   * Getter for the surname.
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
