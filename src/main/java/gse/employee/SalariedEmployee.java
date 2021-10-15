package gse.employee;

/**
 * salaried employee class of the employee project.
 *
 * @author Sergej Bakanow
 */
public class SalariedEmployee extends Employee {

  private float monthlySalary;
  private float overtimeRate;
  private int hoursWorkedOvertime;

  private int weeklyWorkingTime;

  public SalariedEmployee(String surname, String forename, float monthlySalary, float overtimeRate,
                          int weeklyWorkingTime) {
    super(surname, forename);
    if (monthlySalary >= 0 && overtimeRate >= 0 && overtimeRate <= 1
        && weeklyWorkingTime >= 35 && weeklyWorkingTime <= 48) {
      this.monthlySalary = monthlySalary;
      this.overtimeRate = overtimeRate;
      this.weeklyWorkingTime = weeklyWorkingTime;
    }
  }

  /**
   * Returns the monthly salary.
   *
   * @return monthlySalary Returns the monthly salary.
   */
  public float getMonthlySalary() {
    return monthlySalary;
  }

  /**
   * Returns the overtime rate.
   *
   * @return overtimeRate Returns the overtime rate.
   */
  public float getOvertimeRate() {
    return overtimeRate;
  }

  /**
   * Returns the overtime hours worked this month.
   *
   * @return hoursWorkedOvertime Returns the overtime hours worked this month.
   */
  public int getHoursWorkedOvertime() {
    return hoursWorkedOvertime;
  }

  /**
   * Returns the weekly working time.
   *
   * @return weeklyWorkingTime Returns the weekly working time.
   */
  public int getWeeklyWorkingTime() {
    return weeklyWorkingTime;
  }

  /**
   * Sets the hours worked overtime this month.
   *
   * @param hoursWorkedOvertime The hours worked overtime.
   */
  public void setHoursWorkedOvertime(int hoursWorkedOvertime) {
    this.hoursWorkedOvertime = hoursWorkedOvertime;
  }

  /**
   * Calculates the monthly salary, considering hours worked overtime and overtime rate.
   *
   * @return salary The monthly salary.
   */
  @Override
  public float calculateSalary() {
    float hourlySalary = (float) (monthlySalary / (weeklyWorkingTime * 4.33));
    float salary =
        monthlySalary + ((hourlySalary + (hourlySalary * overtimeRate)) * hoursWorkedOvertime);
    yearlySalaryToThisDate += salary;
    return salary;
  }
}
