package gse.employee;

public enum ContractTypeT {
  TimeDependent("Time Contract"),
  Tariff("Tariff Contract"),
  NonTariff("Non Tariff Contract");

  private final String contractName;

  ContractTypeT(String contractName) {
    this.contractName = contractName;
  }

  public String getContractName() {
    return contractName;
  }

  public String toString() {
    return contractName;
  }
}
