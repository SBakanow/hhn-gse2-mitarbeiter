package gse.employee;

/**
 * Extends Employee class
 *
 * @author Dennis Schneider
 */

public class NonTariffEmployee implements IEmployee, ITaxpayer {

  private float monthlySalary;


  public NonTariffEmployee(String forename, String surname, float monthlySalary) {
    if(monthlySalary >= 1) {
      this.monthlySalary = monthlySalary;
    } else {
      throw new NullPointerException("Value must be greater than 0");
    }
  }

  public float getMonthlySalary() {
    return monthlySalary;
  }

  @Override
  public String getForename() {
    return null;
  }

  @Override
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
  public float calculateMonth(float monthlySalary) {
    return 0;
  }

  @Override
  public float calculateSalary() {
    monthlySalary = calculateMonth(monthlySalary);
    return monthlySalary;
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
