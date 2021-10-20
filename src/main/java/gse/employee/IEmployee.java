package gse.employee;

public interface IEmployee {
  float MINIMUMWAGE = 9.50f;
  int WEEKLYWORKINGTIME = 4*40;

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
   * Method to reset the salary.
   * Implemented as protected as no other person is allowed to call it.
   *
   * @param monthlySalary Monthly Salary that gets added.
   */
  float calculateMonth(float monthlySalary);

  float calculateSalary();
}
