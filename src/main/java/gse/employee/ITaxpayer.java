package gse.employee;

/**
 * @author Marvin Simon
 */
public interface ITaxpayer {

  float INCOME_TAX_RATE = 0.36f;

  float actualIncomeTax();

  float anticipatedIncomeTax();

}
