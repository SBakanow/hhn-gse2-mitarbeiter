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
    //Minimal wage Germany
    this.hourlyWage = Math.max(hourlyWage, 9.60f);
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

  @Override
  public String getForename() {
    return null;
  }

  public int getMonthCounter() {
    return 0;
  }

  @Override
  public float getYearlySalaryToThisDate() {
    return 0;
  }

  @Override
  public String getSurname() {
    return null;
  }

  @Override
  public float addToYearlySalary(float monthlySalary) {
    return 0;
  }

  /**
   * Calculates the salary for this month.
   *
   * @return Salary for the current month.
   */
  @Override
  public float calculateSalary() {
    float result = hourlyWage * hoursWorked;
    result = addToYearlySalary(result);
    hoursWorked = 0;
    return result;
  }

  @Override
  public float actualIncomeTax() {
    return 0;
  }

  @Override
  public float anticipatedIncomeTax() {
    return 0;
  }
}
