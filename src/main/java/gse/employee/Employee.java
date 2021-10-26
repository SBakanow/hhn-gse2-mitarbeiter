package gse.employee;

import java.time.Month;

/**
 * Abstract Employee class.
 *
 * @author Marvin Simon, Sergej Bakanow
 */
public abstract class Employee implements IEmployee, ITaxpayer {


  protected String surname;
  protected String forename;
  protected float yearlySalaryToThisDate;

  // current month, starting in January
  private Month currentMonth = Month.JANUARY;

  private final ContractTypeT contract;

  /**
   * Constructor of the abstract class Employee.
   *
   * @param forename The first name of the worker.
   * @param surname The surname of the worker.
   * @param contract The contract type of the worker.
   */
  public Employee(String forename, String surname, ContractTypeT contract) {
    if (forename != null && !forename.isBlank()) {
      this.forename = forename;
    } else {
      throw new IllegalArgumentException("No forename was specified!");
    }
    if (surname != null && !surname.isBlank()) {
      this.surname = surname;
    } else {
      throw new IllegalArgumentException("No surname was specified!");
    }
    if(contract != null) {
      this.contract = contract;
    } else {
      throw new IllegalArgumentException("No contract type was specified!");
    }
    System.out.println(this + " created.");
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
   * Returns the contract of the worker.
   *
   * @return The contract type of the worker.
   */
  @Override
  public ContractTypeT getContract() {
    return contract;
  }

  /**
   * Method to reset the yearly salary after a year has passed.
   * Every time it is called, the month gets added up by one.
   * Starting month: January
   *
   * @param monthlySalary Monthly Salary that gets added.
   *                      Recommended use is to use the calculateSalary with this method.
   */
  protected float addToYearlySalary(float monthlySalary) {
    float result = roundValueToTwoDecimals(monthlySalary);
    if (currentMonth == Month.JANUARY) {
      yearlySalaryToThisDate = 0;
    }
    yearlySalaryToThisDate += result;
    currentMonth = currentMonth.plus(1);
    return result;
  }

  /**
   * Returns the actual tax for the yearly salary to this date.
   *
   * @return The actual tax for the year.
   */
  @Override
  public float actualIncomeTax() {
    float result = yearlySalaryToThisDate * INCOME_TAX_RATE; //Calculate the income tax
    return roundValueToTwoDecimals(result);
  }

  /**
   * Returns the anticipated tax for the whole year by calculating the average income per month
   * and adding the tax for this average income times the remaining months in the year
   * to the actual income tax.
   * We need to subtract one from the month because we begin in January and need to calculate it backwards.
   *
   * @return The anticipated tax for the whole year.
   */
  @Override
  public float anticipatedIncomeTax() {
    int remainingMonths = 12 - currentMonth.minus(1).getValue(); //Calculate the remaining months
    float averageIncomePerMonth = yearlySalaryToThisDate / currentMonth.minus(1).getValue(); //Calculate the average income of the month

    //Calculate the anticipated Income Tax of the remaining months via multiplying the averageIncome, the remaining months and the Tax Rate
    float anticipatedIncomeTaxOfRemainingMonths = averageIncomePerMonth * remainingMonths * INCOME_TAX_RATE;

    //Round the anticipated tax and add the actual income tax
    return roundValueToTwoDecimals(anticipatedIncomeTaxOfRemainingMonths) + actualIncomeTax();
  }

  /**
   * Round the value to two decimal points
   * The rounding formula is Math.round(value * 100) / 100
   * Example:
   * 2,5551 * 100 = 255,51
   * Math.round(255,51) = 256 / 100 = 2,56
   *
   * @param value Value to be rounded
   * @return Value after rounding
   */
  protected float roundValueToTwoDecimals(float value) {
    return (Math.round(value * 100.0f) / 100.0f);
  }

  /**
   * Getter for the current month
   *
   * @return Current month
   */
  public Month getCurrentMonth() {
    return currentMonth;
  }

  /**
   * Add to the name the contract name of the employee.
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + forename + " " + surname + " "
        + contract.getContractName();
  }
}
