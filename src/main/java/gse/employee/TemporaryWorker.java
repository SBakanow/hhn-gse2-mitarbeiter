package gse.employee;

/**
 * This class represents a temporary Worker.
 *
 * @author Noah Schmidt
 */
public class TemporaryWorker extends Employee {

  private final float hourlyWage;
  private int hoursWorked;

  public TemporaryWorker(String forename, String surname, float hourlyWage) {
    super(forename, surname);
    this.hourlyWage = hourlyWage;
    this.hoursWorked = 0;
  }

  /**
   * Return the fixed wage per hour.
   *
   * @return Wage per hour.
   */
  public float getHourlyWage() {
    return hourlyWage;
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
    return hourlyWage * hoursWorked;
  }
}
