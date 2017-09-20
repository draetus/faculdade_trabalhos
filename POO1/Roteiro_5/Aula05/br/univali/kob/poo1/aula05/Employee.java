package br.univali.kob.poo1.aula05;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * 
 */
public class Employee extends Person {
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato String para taxa de hora e
     * formato string na data de nascimento e
     * data de inicio de contrato para
     * facilitar chamada
     * 
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param hireDate Data de contratação
     * @param hoursPerWorkWeek Horas de trabalho por semana
     * @param hourlyRate Preço da hora trabalhada
     */
    public Employee(String name, String dateOfBirth, String hireDate, int hoursPerWorkWeek, String hourlyRate)
    {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), hoursPerWorkWeek, new BigDecimal(hourlyRate));
    }
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato String para taxa de hora para
     * facilitar chamada
     * 
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param hireDate Data de contratação
     * @param hoursPerWorkWeek Horas de trabalho por semana
     * @param hourlyRate Preço da hora trabalhada
     */
    public Employee(String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursPerWorkWeek, String hourlyRate)
    {
        this(name, dateOfBirth, hireDate, hoursPerWorkWeek, new BigDecimal(hourlyRate));
    }
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato string na data de nascimento
     * e data de inicio de contrato para
     * facilitar chamada
     * 
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param hireDate Data de contratação
     * @param hoursPerWorkWeek Horas de trabalho por semana
     * @param hourlyRate Preço da hora trabalhada
     */
    public Employee(String name, String dateOfBirth, String hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate)
    {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), hoursPerWorkWeek, hourlyRate);
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param hireDate Data de contratação
     * @param hoursPerWorkWeek Horas de trabalho por semana
     * @param hourlyRate Preço da hora trabalhada
     */
    public Employee(String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate) {
        super(name, dateOfBirth);
        this.setHireDate(hireDate);
        this.setHourlyRate(hourlyRate);
        this.setHoursPerWorkWeek(hoursPerWorkWeek);
        validadeState();
    }

    /**
     * Data do inicio de contrato
     */
    private LocalDate hireDate;

    /**
     * Data de demissão
     */
    private LocalDate terminationDate;

    /**
     * Horas por semana
     */
    private int hoursPerWorkWeek;

    /**
     * Taxa de pagamento por hora
     */
    private BigDecimal hourlyRate;

    /**
     * Getter
     * @return Data de inicio de contrato
     */
    public LocalDate getHireDate() {
        return this.hireDate;
    }

    /**
     * Setter
     * @param hireDate Data de inicio de contrato
     */
    public void setHireDate(LocalDate hireDate) {
        /*LocalDate today = LocalDate.now();
        if (hireDate == null || hireDate.isAfter(LocalDate.of(today.getDayOfYear(), today.getMonthValue(), today.getDayOfMonth())))
        {
            throw new IllegalArgumentException("The hire date must be superior to both the terminationDate and to the present Date...");
        }*/
        this.hireDate = hireDate;
        this.terminationDate = null;
    }

    /**
     * Getter
     * @return Data de demissão
     */
    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    /**
     * Setter
     * @param terminationDate 
     */
    public void setTerminationDate(LocalDate terminationDate) {
        if (terminationDate == null || terminationDate.isBefore(LocalDate.of(hireDate.getYear(), hireDate.getMonthValue(), hireDate.getDayOfMonth())))
        {
            throw new InternalError("The date must be before the present date...");
        }
        this.terminationDate = terminationDate;
    }

    /**
     * Getter
     * @return Horas por semana
     */
    public int getHoursPerWorkWeek() {
        return this.hoursPerWorkWeek;
    }

    /**
     * @param hoursPerWorkWeek Horas por semana do funcionário
     */
    public void setHoursPerWorkWeek(int hoursPerWorkWeek) {
        this.hoursPerWorkWeek = hoursPerWorkWeek;
        validadeHoursPerWorkWeek();
    }
    
    /**
     * Validação de horas por semana
     */
    private void validadeHoursPerWorkWeek()
    {
        if (hoursPerWorkWeek < 1 || hoursPerWorkWeek > 40)
        {
            throw new IllegalArgumentException("Hours per work week(" + hoursPerWorkWeek +
                    ") is out of range[1..40]");
        }
    }

    /**
     * Getter
     * @return Pagamento por hora
     */
    public BigDecimal getHourlyRate() {
        return this.hourlyRate;
    }

    /**
     * Setter
     * @param hourlyRate Pagamento por hora
     */
    public void setHourlyRate(BigDecimal hourlyRate) throws OutOfRangeException {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Checa para ver se o funcionário ainda é contratado
     * @return True=Contratado; False=Não Contratado
     */
    public boolean isEmployee() {
        return (getTerminationDate() == null);
    }

    /**
     * Calcula e retorna o tempo de serviço do funcionário em anos
     * @return Anos de serviço
     */
    public int getYearsOfService() {
        Period period;
        if (this.isEmployee())
        {
            period = Period.between(getHireDate(), LocalDate.now());
        }
        else
        {
            period = Period.between(getHireDate(), getTerminationDate());
        }
        return period.getYears();
    }

    /**
     * Calcula e retorna o salário base semanal do funcionário
     * @return Salário base semanal
     */
    public BigDecimal getRegularWeekSalary() {
        BigDecimal value = new BigDecimal(getHoursPerWorkWeek());
        value = value.multiply(getHourlyRate());
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * Calcula o salário semanal do funcionário descontando as
     * horas ausentes.
     * @param absentHours Horas ausentes
     * @return Salário semanal
     */
    public BigDecimal getWeekPayment(int absentHours) {
        BigDecimal discount;
        if (getHourlyRate() != null)
        {
            discount = new BigDecimal(absentHours);
            discount = discount.multiply(getHourlyRate());
        }
        else
        {
            discount = new BigDecimal(0);
        }
        return getRegularWeekSalary().subtract(discount);
    }
    
    /**
     * Validação geral
     */
    private void validadeState()
    {
        validadeHoursPerWorkWeek();
    }

    /**
     * Append to String
     * @return String a ser impressa no metodo toString()
     */
    @Override
    protected String appendToString() 
    {
        StringBuilder output = new StringBuilder();
        output.append("  // Employee" + AppConfig.NEW_LINE);
        output.append("  hireDate = " + hireDate.format(AppConfig.DATE_FORMAT) + AppConfig.NEW_LINE);
        output.append("  terminationDate = ");
        output.append(((terminationDate == null) ? null : terminationDate.format(AppConfig.DATE_FORMAT)) + AppConfig.NEW_LINE);
        output.append("  hoursPwerWorkWeek = " + hoursPerWorkWeek + AppConfig.NEW_LINE);
        output.append("  hourlyRate = " + hourlyRate.toPlainString() + AppConfig.NEW_LINE);
        return output.toString();
    }
    
    
    /**
     * Sobrescrevendo método equals que foi sobrescrito em Person
     * @param obj o objeto a ser comparado
     * @return true quando os objetos têm o mesmo estado, false caso contrário
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj))
        {
            return false;
        }
        
        Employee employee = (Employee)obj;
        return
                // testa primeiro com == para ser mais eficiente
                (hireDate == employee.hireDate || hireDate.equals(employee.hireDate)) &&
                Objects.equals(terminationDate, employee.terminationDate) &&
                hoursPerWorkWeek == employee.hoursPerWorkWeek && 
                (hourlyRate == employee.hourlyRate || hourlyRate.equals(employee.hourlyRate));
    }
    
    /* 
     * Sobrescrevendo método sobrescrito em Person
     * 
     * @return o valor calculado a partir do estado atual do objeto
     */
    @Override
    public int hashCode()
    {
        return
                super.hashCode() ^
                hireDate.hashCode() ^
                (terminationDate == null ? 19 : terminationDate.hashCode()) ^
                hoursPerWorkWeek ^
                getHourlyRate().hashCode();
    }
}