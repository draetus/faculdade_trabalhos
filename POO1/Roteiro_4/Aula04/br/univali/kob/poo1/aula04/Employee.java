package br.univali.kob.poo1.aula04;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

/**
 * 
 */
public class Employee extends Person {

    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     */
    public Employee(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
        setTerminationDate(null);
        validadeState();
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param id ID de identificação
     */
    public Employee(String name, LocalDate dateOfBirth, int id) {
        this(name, dateOfBirth);
        this.setId(id);
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param id ID de identificação
     * @param hireDate Data de contratação
     */
    public Employee(String name, LocalDate dateOfBirth, int id, LocalDate hireDate) {
        this(name, dateOfBirth, id);
        this.setHireDate(hireDate);
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param id ID de identificação
     * @param hireDate Data de contratação
     * @param hoursPerWorkWeek Horas de trabalho por semana
     */
    public Employee(String name, LocalDate dateOfBirth, int id, LocalDate hireDate, int hoursPerWorkWeek) {
        this(name, dateOfBirth, id, hireDate);
        this.setHoursPerWorkWeek(hoursPerWorkWeek);
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param id ID de identificação
     * @param hireDate Data de contratação
     * @param hoursPerWorkWeek Horas de trabalho por semana
     * @param hourlyRate Preço da hora trabalhada
     */
    public Employee(String name, LocalDate dateOfBirth, int id, LocalDate hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate) {
        this(name, dateOfBirth, id, hireDate, hoursPerWorkWeek);
        this.setHourlyRate(hourlyRate);
    }

    /**
     * ID de identificação do funcionário
     */
    private int id;

    /**
     * Data do contratamento
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
     * @return ID de identificação do funcionário
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter
     * @param id ID de idenficação do funcionário
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter
     * @return Data de contratação
     */
    public LocalDate getHireDate() {
        return this.hireDate;
    }

    /**
     * Setter
     * @param hireDate Data de contratação
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
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
    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Checa para ver se o funcionário ainda é contratado
     * @return True=Contratado; False=Não Contratado
     */
    public boolean isEmployee() {
        return getTerminationDate() == null;
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
}