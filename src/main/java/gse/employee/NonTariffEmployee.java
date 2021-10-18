package gse.employee;

/**
 * Extends Employee class
 *
 * @author Dennis Schneider
 */

public class NonTariffEmployee extends Employee {

  private float monthlySalary;


  public NonTariffEmployee(String forename, String surname, float monthlySalary) {
    super(forename, surname);
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
  public float calculateSalary() {
    monthlySalary = calculateMonth(monthlySalary);
    return monthlySalary;
  }
}
