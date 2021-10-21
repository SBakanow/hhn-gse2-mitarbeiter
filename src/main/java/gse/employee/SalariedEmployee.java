package gse.employee;

/**
 * Salaried employee class of the employee project.
 *
 * @author Sergej Bakanow
 */
public class SalariedEmployee extends Employee {

  private float monthlySalary;
  private float overtimeRate;
  private int hoursWorkedOvertime;

  private float hourlyWage;

  /**
   * Constructor of the SalariedEmployee class.
   *
   * @param forename      the first name of the worker.
   * @param surname       the surname of the worker.
   * @param monthlySalary the monthly Salary the worker receives.
   * @param overtimeRate  the overtime rate in percent.
   * @param contract      the contract type of the worker
   */
  public SalariedEmployee(String forename, String surname, float monthlySalary,
                          float overtimeRate, ContractTypeT contract) {
    super(forename, surname, contract);
    calculateHourlyWage(monthlySalary);
    if (hourlyWage >= MINIMUM_WAGE && overtimeRate >= 0 && overtimeRate <= 1) {
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
  public float getHourlyWage() {
    return hourlyWage;
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
   * Calculates the hourly wage with the given monthly salary.
   *
   * @param monthlySalary The monthly salary of the worker.
   */
  public void calculateHourlyWage(float monthlySalary) {
    hourlyWage = (monthlySalary / (WEEKLY_WORKING_TIME * 4));
  }

  /**
   * Calculates the monthly salary, considering hours worked overtime and overtime rate.
   *
   * @return The monthly salary.
   */
  @Override
  public float calculateSalary() {
    float salary =
        monthlySalary + ((hourlyWage + (hourlyWage * overtimeRate)) * hoursWorkedOvertime);
    salary = calculateMonth(salary);
    hoursWorkedOvertime = 0;
    return salary;
  }
}
