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
    SalariedEmployee sergej = new SalariedEmployee("Sergej", "Bakanow", 3550, 0.5f, 35);
    System.out.println(sergej);
    for (int i = 0; i < 12; i++) {
      sergej.setHoursWorkedOvertime((int) Math.round(i * 2.1));
      System.out.println("Month " + (i+1) + ". " + sergej.calculateSalary());
    }
    System.out.println("Yearly Salary: " + sergej.getYearlySalaryToThisDate());
  }

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
    return getClass().getSimpleName() + " " + forename + " " + surname;
  }

  public abstract float calculateSalary();
}
