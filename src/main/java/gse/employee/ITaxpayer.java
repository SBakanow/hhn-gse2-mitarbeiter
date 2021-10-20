package gse.employee;

public interface ITaxpayer {

  float INCOME_TAX_RATE = 0.36f;

  float actualIncomeTax();

  float anticipatedIncomeTax();

}
