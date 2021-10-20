package gse.employee;

/**
 * @author Marvin Simon
 */
public interface IEmployee {

  float MINIMUM_WAGE = 9.60f; //Since the 1. July (+10cent... wow)
  int WEEKLY_WORKING_TIME = 160; //Hours (4 Weeks x 40h)

  /**
   * Getter for the forename.
   *
   * @return Forename of the employee
   */
  String getForename();

  /**
   * Get the Month Counter
   *
   * @return Month Counter
   */
  int getMonthCounter();

  /**
   * Getter SummedUpSalary.
   *
   * @return Summed up salary to this day
   */
  float getYearlySalaryToThisDate();

  /**
   * Getter for the surname.
   *
   * @return Surname of the employee
   */
  String getSurname();

  /**
   * Method to reset the salary and round the number.
   * The rounding formula is Math.round(monthlySalary * 100) / 100
   * 2,5551 * 100 = 255,51
   * Math.round(255,51) = 256 / 100 = 2,56
   *
   * @param monthlySalary Monthly Salary that gets added.
   */
  float calculateMonth(float monthlySalary);

  /**
   * Method to calculate the salary.
   *
   * @return The calculated salary
   */
  float calculateSalary();
}
