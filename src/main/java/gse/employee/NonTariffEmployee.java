package gse.employee;


import java.util.Date;

/**
 * Extends Employee class
 *
 * @author Dennis Schneider
 */

public class NonTariffEmployee extends Employee {

  private final float monthlySalary;
  private Date date;


  public NonTariffEmployee(String forename, String surname, float monthlySalary) {
    super(forename, surname);
    this.monthlySalary = monthlySalary;
    Date date = new Date();

  }

  public float getMonthlySalary() {
    return monthlySalary;
  }

  //TODO
  @Override
  public float calculateSalary() {
    yearlySalaryToThisDate = monthlySalary * (date.getMonth() + 1);
    return monthlySalary;
  }
}
