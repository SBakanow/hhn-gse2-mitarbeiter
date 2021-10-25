package gse.employee;

public class Main {

  /**
   * Main method of the program.
   *
   * @param args Command Line Arguments
   */
  public static void main(String[] args) {
    SalariedEmployee sergej =
        new SalariedEmployee("Sergej", "Bakanow", 3000, 30.5f, ContractTypeT.Tariff);
    TemporaryWorker noah =
        new TemporaryWorker("Noah", "Schmidt", 9.60f, ContractTypeT.TimeDependent);
    NonTariffEmployee dennis =
        new NonTariffEmployee("Dennis", "Schneider", 10000.0f, ContractTypeT.NonTariff);
    try {
      System.out.println("********************");
      for (int i = 0; i < 12; i++) {
        sergej.setHoursWorkedOvertime((int) Math.round(i * 2.1));
        noah.setHoursWorked(150 - i);

        System.out.println("Month " + sergej.getCurrentMonth());
        System.out.println("Monthly income: ");

        System.out.println(sergej + ": " + sergej.calculateSalary() + "€");
        System.out.println(dennis + ": " + dennis.calculateSalary() + "€");
        System.out.println(noah + ": " + noah.calculateSalary() + "€");

        System.out.println();

        System.out.println("Actual income taxes: ");

        System.out.println(sergej + ": " + sergej.actualIncomeTax() + "€");
        System.out.println(dennis + ": " + dennis.actualIncomeTax() + "€");
        System.out.println(noah + ": " + noah.actualIncomeTax() + "€");

        System.out.println();
        System.out.println("Predicted Yearly Income taxes to this date: ");

        System.out.println(sergej + ": " + sergej.anticipatedIncomeTax() + "€");
        System.out.println(dennis + ": " + dennis.anticipatedIncomeTax() + "€");
        System.out.println(noah + ": " + noah.anticipatedIncomeTax() + "€");

        System.out.println("---------------------");
        System.out.println();
      }

      System.out.println("Yearly Salary to this date: ");
      System.out.println(sergej + " Yearly Salary to this Date: " + sergej.getYearlySalaryToThisDate() + "€");
      System.out.println(dennis + " Yearly Salary to this Date: " + dennis.getYearlySalaryToThisDate() + "€");
      System.out.println(noah + " Yearly Salary to this Date: " + noah.getYearlySalaryToThisDate() + "€");

      System.out.println("---------------------");
      System.out.println();
      System.out.println("NEW YEAR STARTED");

      System.out.println("Month " + sergej.getCurrentMonth());
      sergej.setHoursWorkedOvertime((int) Math.round(1 * 2.1));
      noah.setHoursWorked(150 - 1);

      System.out.println("Monthly income:");
      System.out.println(sergej + ": " + sergej.calculateSalary() + "€");
      System.out.println(dennis + ": " + dennis.calculateSalary() + "€");
      System.out.println(noah + ": " + noah.calculateSalary() + "€");

      System.out.println();

      System.out.println(sergej + " Yearly Salary to this Date: " + sergej.getYearlySalaryToThisDate() + "€");
      System.out.println(dennis + " Yearly Salary to this Date: " + dennis.getYearlySalaryToThisDate() + "€");
      System.out.println(noah + " Yearly Salary to this Date: " + noah.getYearlySalaryToThisDate() + "€");

      System.out.println();
      System.out.println("Actual Income taxes: ");
      System.out.println(sergej + ": " + sergej.actualIncomeTax() + "€");
      System.out.println(dennis +": " + dennis.actualIncomeTax() + "€");
      System.out.println(noah + ": " + noah.actualIncomeTax() + "€");

      System.out.println();

      System.out.println("Anticipated income taxes: ");
      System.out.println(sergej + ": " + sergej.anticipatedIncomeTax() + "€");
      System.out.println(dennis + ": " + dennis.anticipatedIncomeTax() + "€");
      System.out.println(noah + ": " + noah.anticipatedIncomeTax() + "€");

    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
  }
}
