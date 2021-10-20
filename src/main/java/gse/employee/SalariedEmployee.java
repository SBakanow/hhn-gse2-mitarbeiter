package gse.employee;

import java.time.Month;

/**
 * salaried employee class of the employee project.
 *
 * @author Sergej Bakanow
 */
public class SalariedEmployee implements IEmployee, ITaxpayer {

  private float monthlySalary;
  private float overtimeRate;
  private int hoursWorkedOvertime;

  private String surname;
  private String forename;
  private float yearlySalaryToThisDate;
  private int monthCounter = 0;

  private float hourlySalary;
  private ContractTypeT contract;

  // current month, starting in January
  private Month currentMonth = Month.JANUARY;

  /**
   * constructor of the SalariedEmployee class.
   *
   * @param forename      the first name of the worker.
   * @param surname       the surname of the worker.
   * @param monthlySalary the monthly Salary the worker receives.
   * @param overtimeRate  the overtime rate in percent.
   */
  public SalariedEmployee(String forename, String surname, float monthlySalary,
                          float overtimeRate) {
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
    calculateHourlySalary(monthlySalary);
    if (hourlySalary >= MINIMUMWAGE && overtimeRate >= 0 && overtimeRate <= 1) {
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
   * Getter for the surname.
   *
   * @return Surname of the employee
   */
  @Override
  public String getSurname() {
    return surname;
  }

  /**
   * Getter for the forename.
   *
   * @return Forename of the employee
   */
  @Override
  public String getForename() {
    return forename;
  }

  /**
   * Getter SummedUpSalary.
   *
   * @return Summed up salary to this day
   */
  @Override
  public float getYearlySalaryToThisDate() {
    return yearlySalaryToThisDate;
  }

  /**
   * Get the Month Counter.
   *
   * @return Month Counter
   */
  @Override
  public int getMonthCounter() {
    return monthCounter;
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
   * Returns the contract of the worker.
   *
   * @return the contract of the worker.
   */
  public ContractTypeT getContract() {
    return contract;
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
   * Sets the contract type for the worker.
   *
   * @param contractType the contract type.
   */
  public void setContract(contractTypeT contractType) {

  }

  /**
   * Calculates the hourly salary with the given monthly salary.
   *
   * @param monthlySalary the monthly salary of the worker.
   */
  public void calculateHourlySalary(float monthlySalary) {
    hourlySalary = (monthlySalary / (WEEKLYWORKINGTIME * 4));
  }

  /**
   * Calculates the monthly salary, considering hours worked overtime and overtime rate.
   *
   * @return salary The monthly salary.
   */
  @Override
  public float calculateSalary() {
    float hourlySalary = (monthlySalary / (WEEKLYWORKINGTIME * 4.33f));
    float salary =
        monthlySalary + ((hourlySalary + (hourlySalary * overtimeRate)) * hoursWorkedOvertime);
    salary = calculateMonth(salary);
    hoursWorkedOvertime = 0;
    return salary;
  }

  /**
   * Method to reset the yearly salary after a year has passed.
   * Implemented as protected as no other person is allowed to call it.
   *
   * @param monthlySalary Monthly Salary that gets added.
   */
  @Override
  public float calculateMonth(float monthlySalary) {
    float result = (Math.round(monthlySalary * 100.0f) / 100.0f);
    if (currentMonth == Month.JANUARY) {
      yearlySalaryToThisDate = 0;
    }
    yearlySalaryToThisDate += result;
    currentMonth = currentMonth.plus(1);
    return result;
  }

  public float actualIncomeTax() {
    return yearlySalaryToThisDate * INCOME_TAX_RATE;
  }

  public float anticipatedIncomeTax() {
    int remainingMonths = currentMonth.getValue();
    float averageIncomePerMonth = yearlySalaryToThisDate / currentMonth.getValue();
    return averageIncomePerMonth * remainingMonths * INCOME_TAX_RATE + actualIncomeTax();
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + forename + " " + surname + " " + contract;
  }
}
