package br.univali.kob.poo1.aula06;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Mauricio
 */
public class Professor extends Employee{
    
    private AcademicDegree academicDegree;
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato string na data de nascimento
     * e na data de inicio de contrato
     * e formato String na taxa de hora para
     * facilitar chamada
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(String name, String dateOfBirth, String email, String hireDate, int hoursPerWorkWeek, String hourlyRate, AcademicDegree academicDegree) {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), email, LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), hoursPerWorkWeek, new BigDecimal(hourlyRate), academicDegree);
    }
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato String no valor da hora para
     * facilitar chamada
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(String name, LocalDate dateOfBirth, String email, LocalDate hireDate, int hoursPerWorkWeek, String hourlyRate, AcademicDegree academicDegree) {
        this(name, dateOfBirth, email, hireDate, hoursPerWorkWeek, new BigDecimal(hourlyRate), academicDegree);
    }
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato string na data de nascimento
     * e na data de inicio de contrato
     * facilitar chamada
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(String name, String dateOfBirth, String email, String hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate, AcademicDegree academicDegree) {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), email, LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), hoursPerWorkWeek, hourlyRate, academicDegree);
    }
    
    /**
     * Construtor
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(String name, LocalDate dateOfBirth, String email, LocalDate hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate, AcademicDegree academicDegree) {
        super(name, dateOfBirth, email, hireDate, hoursPerWorkWeek, hourlyRate);
        this.setAcademicDegree(academicDegree);
    }
    
    /**
     * Setter
     * @param academicDegree Grau de formação academica do professor
     */
    public void setAcademicDegree(AcademicDegree academicDegree)
    {
        this.academicDegree = academicDegree;
    }
    
    /**
     * Getter
     * @return Grau de formação academica professor
     */
    public AcademicDegree getAcademicDegree()
    {
        return this.academicDegree;
    }
    
    /**
     * Getter
     * @return Descrição do grau de formação academica do professor 
     */
    public String getAcademicDegreeDescription()
    {
        return academicDegree.getDescription();
    }
    
    /**
     * Getter
     * @return Bonus de salario baseado no grau de formação academica do professor
     */
    public BigDecimal getAcademicBonus()
    {
        BigDecimal bonus = super.getHourlyRate().multiply(new BigDecimal(academicDegree.getBonus()));
        return bonus.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    
    /**
     * Getter
     * @return Valor da hora do professor
     */
    @Override
    public BigDecimal getHourlyRate()
    {
        return super.getHourlyRate().add(this.getAcademicBonus());
    }
    
    /**
     * Append to String
     * @return String a ser impressa no metodo toString()
     */
    @Override
    protected String appendToString()
    {
        StringBuilder output = new StringBuilder(super.appendToString());
        output.append("  // Professor" + AppConfig.NEW_LINE);
        output.append("  academicDegree = " + academicDegree + AppConfig.NEW_LINE);
        return output.toString();
    }
    
    
    /**
     * Sobrescrevendo método equals que foi sobrescrito em Employee
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
        
        Professor professor = (Professor)obj;
        
        return
                academicDegree == professor.academicDegree || academicDegree.equals(professor.academicDegree);
    }
    
    /* 
     * Sobrescrevendo método sobrescrito em Employee
     * 
     * @return o valor calculado a partir do estado atual do objeto
     */
    @Override
    public int hashCode()
    {
        return
                super.hashCode() ^
                academicDegree.ordinal();
    }
}