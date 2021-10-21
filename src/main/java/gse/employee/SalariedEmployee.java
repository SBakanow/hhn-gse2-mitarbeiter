package gse.employee;

import java.time.Month;

/**
 * salaried employee class of the employee project.
 *
 * @author Sergej Bakanow
 */
public class SalariedEmployee extends Employee implements IEmployee, ITaxpayer {

  private float monthlySalary;
  private float overtimeRate;
  private int hoursWorkedOvertime;

  private float hourlySalary;

  /**
   * constructor of the SalariedEmployee class.
   *
   * @param forename      the first name of the worker.
   * @param surname       the surname of the worker.
   * @param monthlySalary the monthly Salary the worker receives.
   * @param overtimeRate  the overtime rate in percent.
   */
  public SalariedEmployee(String forename, String surname, float monthlySalary,
                          float overtimeRate, ContractTypeT contract) {
    super(forename, surname, contract);
    calculateHourlySalary(monthlySalary);
    if (hourlySalary >= MINIMUM_WAGE && overtimeRate >= 0 && overtimeRate <= 1) {
      this.monthlySalary = monthlySalary;
      this.overtimeRate = overtimeRate;
    } else {
      throw new IllegalArgumentException("Some values were not in accordance with the law.");
    }
  }

  /**
   * Returns the monthly salary.
   *
   * @return Returns the monthly salary.
   */
  public float getMonthlySalary() {
    return monthlySalary;
  }

  /**
   * Returns the overtime rate.
   *
   * @return Returns the overtime rate.
   */
  public float getOvertimeRate() {
    return overtimeRate;
  }

  /**
   * Returns the overtime hours worked this month.
   *
   * @return Returns the overtime hours worked this month.
   */
  public int getHoursWorkedOvertime() {
    return hoursWorkedOvertime;
  }

  /**
   * Returns the hourly salary of the worker.
   *
   * @return the hourly salary of the worker.
   */
  public float getHourlySalary() {
    return hourlySalary;
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
   * Calculates the hourly salary with the given monthly salary.
   *
   * @param monthlySalary the monthly salary of the worker.
   */
  public void calculateHourlySalary(float monthlySalary) {
    hourlySalary = (monthlySalary / (WEEKLY_WORKING_TIME * 4));
  }

  /**
   * Calculates the monthly salary, considering hours worked overtime and overtime rate.
   *
   * @return salary The monthly salary.
   */
  @Override
  public float calculateSalary() {
    float hourlySalary = (monthlySalary / (WEEKLY_WORKING_TIME * 4.33f));
    float salary =
        monthlySalary + ((hourlySalary + (hourlySalary * overtimeRate)) * hoursWorkedOvertime);
    salary = calculateMonth(salary);
    hoursWorkedOvertime = 0;
    return salary;
  }
}
