package gse.employee;

/**
 * Extends Employee class
 *
 * @author Dennis Schneider
 */

public class NonTariffEmployee extends Employee {

  private float monthlySalary;


  public NonTariffEmployee(String forename, String surname, float monthlySalary,
                           ContractTypeT contractType) {
    super(forename, surname, contractType);
    if (monthlySalary < MINIMUM_WAGE * MONTHLY_WORKING_TIME) {
      throw new IllegalArgumentException("You need to pay at least 9.60 Euro minimum wage!");
    } else {
      this.monthlySalary = monthlySalary;
    }
  }

  public float getMonthlySalary() {
    return monthlySalary;
  }

  @Override
  public String getForename() {
    return forename;
  }

  @Override
  public String getSurname() {
    return surname;
  }

  @Override
  public float calculateSalary() {
    monthlySalary = addToYearlySalary(monthlySalary);
    return monthlySalary;
  }

}
