package gse.employee;

/**
 * @author Marvin Simon
 */
public interface IEmployee {

  float MINIMUM_WAGE = 9.60f; //Since the 1. July (+10cent... wow)
  int WEEKLY_WORKING_TIME = 40; //Hours per week
  int WEEKS_IN_A_MONTH = 4; //Number of weeks in a month
  int MONTHLY_WORKING_TIME = WEEKLY_WORKING_TIME * WEEKS_IN_A_MONTH; //Hours per Month

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
   * Method to calculate the salary.
   *
   * @return The calculated salary
   */
  float calculateSalary();

  /**
   * Return the fore and surname of the employee and his class name.
   *
   * @return String of the fore and surname
   */
  String toString();
}
