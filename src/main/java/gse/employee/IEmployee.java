package gse.employee;

/**
 * @author Marvin Simon
 */
public interface IEmployee {

  float MINIMUM_WAGE = 9.60f; //Since the 1. July (+10cent... wow)
  int WEEKLY_WORKING_TIME = 40; //Hours per week
  int MONTHLY_WORKING_TIME = WEEKLY_WORKING_TIME * 4; //Hours per Month
  int WEEKS_IN_A_MONTH = 4; //number of weeks in a month

  /**
   * Getter for the forename.
   *
   * @return Forename of the employee
   */
  String getForename();

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
   * Method to reset the yearly salary after a year has passed and round the number to
   * two decimal places.
   * The rounding formula is Math.round(monthlySalary * 100) / 100
   * 2,5551 * 100 = 255,51
   * Math.round(255,51) = 256 / 100 = 2,56
   *
   * @param monthlySalary Monthly Salary that gets added.
   */
  float addToYearlySalary(float monthlySalary);

  /**
   * Method to calculate the salary.
   *
   * @return The calculated salary
   */
  float calculateSalary();
}
