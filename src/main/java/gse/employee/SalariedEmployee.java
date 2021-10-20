package gse.employee;

/**
 * salaried employee class of the employee project.
 *
 * @author Sergej Bakanow
 */
public class SalariedEmployee implements IEmployee, ITaxpayer {

  private float monthlySalary;
  private float overtimeRate;
  private int hoursWorkedOvertime;
  private final int WEEKLYWORKINGTIME = 40;

  private String surname;
  private String forename;
  private float yearlySalaryToThisDate;
  private float hourlySalary;

  private ContractTypeT contract;
  private int monthCounter = 0;

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
   * Returns the weekly working time.
   *
   * @return Returns the weekly working time.
   */
  public int getWEEKLYWORKINGTIME() {
    return WEEKLYWORKINGTIME;
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
    float hourlySalary = (monthlySalary / (WEEKLYWORKINGTIME * 4.33f));
    float salary =
        monthlySalary + ((hourlySalary + (hourlySalary * overtimeRate)) * hoursWorkedOvertime);
    salary = calculateMonth(salary);
    hoursWorkedOvertime = 0;
    contract = ContractTypeT.TariffContract;
    return salary;
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
   * Calculates the hourly salary with the given monthly salary.
   *
   * @param monthlySalary the monthly salary of the worker.
   */
  public void calculateHourlySalary(float monthlySalary) {
    hourlySalary = (monthlySalary / (WEEKLYWORKINGTIME * 4f));
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
   * Get the Month Counter.
   *
   * @return Month Counter
   */
  public int getMonthCounter() {
    return monthCounter;
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

  /**
   * Method to reset the yearly salary after a year has passed.
   * Implemented as protected as no other person is allowed to call it.
   *
   * @param monthlySalary Monthly Salary that gets added.
   */
  public float calculateMonth(float monthlySalary) {
    float result = (Math.round(monthlySalary * 100.0f) / 100.0f);
    if (monthCounter < 12) {
      yearlySalaryToThisDate += result;
      monthCounter++;
    } else {
      yearlySalaryToThisDate = result;
      monthCounter = 0;
    }
    return result;
  }

  public float actualIncomeTax() {
    return yearlySalaryToThisDate * INCOMETAXRATE;
  }

  public float anticipatedIncomeTax() {
    return 0;
  }

  public void setContract(ContractTypeT contractType) {

  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + forename + " " + surname + " " + contract;
  }
}
