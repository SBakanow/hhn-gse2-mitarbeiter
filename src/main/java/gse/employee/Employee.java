package gse.employee;

/**
 * Abstract Employee class.
 *
 * @author Marvin Simon
 */
public abstract class Employee {

  protected String surname;
  protected String forename;
  protected float yearlySalaryToThisDate;

  protected int monthCounter = 0;

  /**
   * Main method of the program.
   *
   * @param args Command Line Arguments
   */
  public static void main(String[] args) {
    try {
      SalariedEmployee sergej = new SalariedEmployee("Sergej", "Bakanow", 3550, 0.5f, 35);
      TemporaryWorker noah = new TemporaryWorker("Noah", "Schmidt", 9.60f);
      NonTariffEmployee dennis = new NonTariffEmployee("Dennis", "Schneider", 10000.0f);

      System.out.println("********************");
      for (int i = 0; i < 12; i++) {
        sergej.setHoursWorkedOvertime((int) Math.round(i * 2.1));
        noah.setHoursWorked(150 - i);
        System.out.println(sergej + " Month " + (i + 1) + ": " + sergej.calculateSalary() + "€");
        System.out.println(dennis + " Month " + (i + 1) + ": " + dennis.calculateSalary() + "€");
        System.out.println(noah + " Month " + (i + 1) + ": " + noah.calculateSalary() + "€");
        System.out.println("---------------------");
      }
      System.out.println(sergej + " Yearly Salary: " + sergej.getYearlySalaryToThisDate() + "€");
      System.out.println(noah + " Yearly Salary: " + noah.getYearlySalaryToThisDate() + "€");
      System.out.println(dennis + " Yearly Salary: " + dennis.getYearlySalaryToThisDate() + "€");

      System.out.println("---------------------");

      sergej.setHoursWorkedOvertime((int) Math.round(1 * 2.1));
      noah.setHoursWorked(150 - 1);

      System.out.println(sergej + " Month " + 1 + ": " + sergej.calculateSalary() + "€");
      System.out.println(dennis + " Month " + 1 + ": " + dennis.calculateSalary() + "€");
      System.out.println(noah + " Month " + 1 + ": " + noah.calculateSalary() + "€");

      System.out.println("---------------------");

      System.out.println(sergej + " Yearly Salary: " + sergej.getYearlySalaryToThisDate() + "€");
      System.out.println(noah + " Yearly Salary: " + noah.getYearlySalaryToThisDate() + "€");
      System.out.println(dennis + " Yearly Salary: " + dennis.getYearlySalaryToThisDate() + "€");

      System.out.println("********************");
    } catch (NullPointerException ex) {
      ex.printStackTrace();
    }


  }

  public Employee(String forename, String surname) {
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
   * Get the Month Counter
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
   * Method to reset the salary.
   * Implemented as protected as no other person is allowed to call it.
   *
   * @param monthlySalary Monthly Salary that gets added.
   */
  protected float calculateMonth(float monthlySalary) {
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

  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + forename + " " + surname;
  }

  public abstract float calculateSalary();
}
