package gse.employee;

import java.time.Month;

/**
 * Abstract Employee class.
 *
 * @author Marvin Simon
 */
public abstract class Employee implements IEmployee, ITaxpayer {

  protected String surname;
  protected String forename;
  protected float yearlySalaryToThisDate;

  // current month, starting in January
  private Month currentMonth = Month.JANUARY;

  private ContractTypeT contract;

  public Employee(String forename, String surname, ContractTypeT contract) {
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

    this.contract = contract;
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
   * @return the contract of the worker.
   */
  public ContractTypeT getContract() {
    return contract;
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

  /**
   * Returns the actual tax for the year.
   *
   * @return the actual tax for the year.
   */
  public float actualIncomeTax() {
    return yearlySalaryToThisDate * INCOME_TAX_RATE;
  }

  /**
   * Returns the anticipated tax for the whole year.
   *
   * @return the anticipated tax for the whole year.
   */
  public float anticipatedIncomeTax() {
    int remainingMonths = currentMonth.getValue();
    float averageIncomePerMonth = yearlySalaryToThisDate / currentMonth.getValue();
    return averageIncomePerMonth * remainingMonths * INCOME_TAX_RATE + actualIncomeTax();
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + forename + " " + surname + " "
        + contract.getContractName();
  }
}
