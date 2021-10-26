package gse.employee;

/**
 * Interface representing a Taxpayer.
 *
 * @author Marvin Simon
 */
public interface ITaxpayer {

  float INCOME_TAX_RATE = 0.36f;

  /**
   * Returns the actual tax for the yearly salary to this date.
   *
   * @return The actual tax for the year.
   */
  float actualIncomeTax();

  /**
   * Returns the anticipated tax for the whole year by calculating the average income per month
   * and adding the tax for this average income times the remaining months in the year
   * to the actual income tax.
   *
   * @return The anticipated tax for the whole year.
   */
  float anticipatedIncomeTax();

}
