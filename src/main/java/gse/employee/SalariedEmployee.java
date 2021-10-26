package gse.employee;

/**
 * Salaried employee class of the employee project.
 *
 * @author Sergej Bakanow
 */
public class SalariedEmployee extends Employee {

  private final float monthlySalary;

  // the overtime tariff for overtime hours in €
  private final float overtimeTariff;
  private int hoursWorkedOvertime;

  /* hourly wage calculated from the monthly salary, considering a weekly work time of 40 hours
  and 4 weeks in a month
   */
  private float hourlyWage;

  /**
   * Constructor of the SalariedEmployee class.
   *
   * @param forename       the first name of the worker.
   * @param surname        the surname of the worker.
   * @param monthlySalary  the monthly Salary the worker receives.
   * @param overtimeTariff the overtime tariff the worker gets per hour.
   * @param contract       the contract type of the worker.
   */
  public SalariedEmployee(String forename, String surname, float monthlySalary,
                          float overtimeTariff, ContractTypeT contract) {
    super(forename, surname, contract);

    // calculating the hourly wage for the minimum wage check
    calculateHourlyWage(monthlySalary);

    /* checking if the hourly wage meets at least the minimum wage and if the overtime tariff meets
    at least the hourly wage, since it would make no sense to get less money overtime than the
    hourly wage
    */
    if (hourlyWage >= MINIMUM_WAGE && overtimeTariff >= hourlyWage) {
      this.monthlySalary = monthlySalary;
      this.overtimeTariff = overtimeTariff;
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
   * Returns the hourly overtime tariff for working overtime hours.
   *
   * @return Returns the overtime tariff.
   */
  public float getOvertimeTariff() {
    return overtimeTariff;
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
   * Returns the hourly wage of the worker.
   *
   * @return the hourly wage of the worker.
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
   * Calculates the hourly wage with the given monthly salary and the weekly work time times
   * the weeks in a month. Overtime hours and the overtime tariff are not taken into account, since
   * they are not part of the hourly wage of the tariff.
   *
   * @param monthlySalary The monthly salary of the worker.
   */
  public void calculateHourlyWage(float monthlySalary) {
    hourlyWage = roundValueToTwoDecimals(monthlySalary / MONTHLY_WORKING_TIME);
  }

  /**
   * Calculates the actual monthly salary, considering hours worked overtime and overtime tariff,
   * adding the monthly salary to the yearly salary to this date with the method call
   * addToYearlySalary and setting the hours worked overtime back to zero at the end of each month.
   *
   * @return The actual monthly salary after adding compensation for overtime work.
   */
  @Override
  public float calculateSalary() {
    float salary = monthlySalary + (overtimeTariff * hoursWorkedOvertime);
    salary = addToYearlySalary(salary);
    hoursWorkedOvertime = 0;
    return salary;
  }
}
