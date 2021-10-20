package gse.employee;

public class Main {

  /**
   * Main method of the program.
   *
   * @param args Command Line Arguments
   */
  public static void main(String[] args) {
      IEmployee sergej = new SalariedEmployee("Sergej", "Bakanow", 3550, 0.5f);
      System.out.println(sergej);
      /*TemporaryWorker noah = new TemporaryWorker("Noah", "Schmidt", 9.60f);
      NonTariffEmployee dennis = new NonTariffEmployee("Dennis", "Schneider", 10000.0f);

      System.out.println("********************");
      for (int i = 0; i < 12; i++) {
        ((SalariedEmployee) sergej).setHoursWorkedOvertime((int) Math.round(i * 2.1));
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

      ((SalariedEmployee) sergej).setHoursWorkedOvertime((int) Math.round(1 * 2.1));
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
    }*/
  }
}
