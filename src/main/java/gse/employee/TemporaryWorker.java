package gse.employee;

/**
 * This class represents a "Zeitarbeiter".
 *
 * @author Noah Schmidt
 */
public class TemporaryWorker extends Employee {

  private final float monthlySalary;
  private int hoursWorked;

  public TemporaryWorker(String forename, String surname, float monthlySalary) {
    super(forename, surname);
    this.monthlySalary = monthlySalary;
    this.hoursWorked = 0;
  }

  /**
   * Return the fixed monthly salary.
   *
   * @return Salary determined by the employment contract.
   */
  public float getMonthlySalary() {
    return monthlySalary;
  }

  /**
   * Returns the hours worked this month.
   *
   * @return Hours worked this month.
   */
  public int getHoursWorked() {
    return hoursWorked;
  }

  /**
   * Sets the hours worked this month.
   *
   * @param hoursWorked The hours worked.
   */
  public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
  }


  /**
   * Calculates the salary for this month.
   *
   * @return Salary for the current month.
   */
  @Override
  public float calculateSalary() {
    return monthlySalary * hoursWorked;
  }
}
