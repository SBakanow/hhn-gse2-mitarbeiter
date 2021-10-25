package gse.employee;

/**
 * This class represents a temporary worker.
 *
 * @author Noah Schmidt
 */
public class TemporaryWorker extends Employee {

    // The hourlyWage is final and can only be changed by a new contract.
    private final float hourlyWage;

    // Number of hours worked.
    private int hoursWorked;


    /**
     * Constructor of the TemporaryWorker class.
     *
     * @param forename      the first name of the worker.
     * @param surname       the surname of the worker.
     * @param hourlyWage    the wage per hour this worker will earn.
     * @param contractType  the type of contract given.
     */
    public TemporaryWorker(String forename, String surname, float hourlyWage, ContractTypeT contractType) {
        super(forename, surname, contractType);

        //Checks whether the stated wage is higher than the statutory minimum wage.
        // If it´s lower an exception will be thrown.
        if (hourlyWage < MINIMUM_WAGE) {
            throw new IllegalArgumentException("The stated salary does not correspond to the minimum wage");
        }

        //Initializes hourlyWage and hoursWorked.
        this.hourlyWage = hourlyWage;
        this.hoursWorked = 0;
    }

    @Override
    public String getForename() {
        return forename;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    /**
     * Return the fixed wage per hour.
     *
     * @return Wage per hour.
     */
    public float getHourlyWage() {
        return hourlyWage;
    }

    /**
     * Returns the hours worked this month.
     *
     * @return Hours worked this month.
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Sets the hours worked this month.
     *
     * @param hoursWorked The hours worked this month.
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Calculates the salary for this month.
     *
     * @return Salary for the current month.
     */
    @Override
    public float calculateSalary() {
        float result = hourlyWage * hoursWorked;
        result = addToYearlySalary(result);
        hoursWorked = 0;
        return result;
    }
}
