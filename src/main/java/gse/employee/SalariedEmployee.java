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

  public SalariedEmployee(String name, String surname, float monthlySalary, float overtimeRate,
                          int weeklyWorkingTime) {
    super(name, surname);
    if (monthlySalary >= 0 && overtimeRate >= 0 && overtimeRate <= 0.25
        && weeklyWorkingTime >= 0 && weeklyWorkingTime <= 40) {
      this.monthlySalary = monthlySalary;
      this.overtimeRate = overtimeRate;
      this.weeklyWorkingTime = weeklyWorkingTime;
    }
  }

  // start of getter
  public float getMonthlySalary() {
    return monthlySalary;
  }

  public float getOvertimeRate() {
    return overtimeRate;
  }

  public int getHoursWorkedOvertime() {
    return hoursWorkedOvertime;
  }

  public int getWeeklyWorkingTime() {
    return weeklyWorkingTime;
  }

  // start of setter
  public void setHoursWorkedOvertime(int hoursWorkedOvertime) {
    this.hoursWorkedOvertime = hoursWorkedOvertime;
  }

  /**
   * Calculates the monthly salary, considering hours worked overtime and overtime rate.
   *
   * @return salary The monthly salary.
   */
  public float calculateSalary() {
    float hourlySalary = (float) (monthlySalary / (weeklyWorkingTime * 4.33));
    float salary =
        monthlySalary + ((hourlySalary + (hourlySalary * overtimeRate)) * hoursWorkedOvertime);
    yearlySalaryToThisDate += salary;
    return salary;
  }
}
