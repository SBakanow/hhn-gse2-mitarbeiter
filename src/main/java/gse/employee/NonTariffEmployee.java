package gse.employee;

/**
 * Extends Employee class
 *
 * @author Dennis Schneider
 */

public class NonTariffEmployee extends Employee {

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
  public float addToYearlySalary(float monthlySalary) {
    return 0;
  }

  @Override
  public float calculateSalary() {
    monthlySalary = this.addToYearlySalary(monthlySalary);
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
