package br.univali.kob.poo1.aula05;

import java.time.LocalDate;

/**
 * Classe base para a hierarquia de estudantes no sistema acadêmico.
 * @author Mauricio
 */
public class Student extends Person {
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato string na data de nascimento
     * e na data de inicio para
     * facilitar chamada
     * 
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param enrollmentDate Data de inicio
     */
    public Student(String name, String dateOfBirth, String enrollmentDate)
    {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), LocalDate.parse(enrollmentDate, AppConfig.DATE_FORMAT));
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param enrollmentDate Data de inicio
     */
    public Student(String name, LocalDate dateOfBirth, LocalDate enrollmentDate)
    {
        super(name, dateOfBirth);
        this.setEnrollmentDate(enrollmentDate);
    }
    
    /**
     * Data em que o estudante ingressou
     */
    private LocalDate enrollmentDate;
    
    /**
     * Data em que o estudante saiu
     */
    private LocalDate dropDate;
    
    /**
     * Informa se o aluno está ou não matriculado
     * @return True=Matriculado; False=Não matriculado
     */
    public boolean isEnrolled()
    {
        return this.dropDate == null;
    }
    
    /**
     * Setter
     * @param enrollmentDate Data de entrada do estudante
     */
    public void setEnrollmentDate(LocalDate enrollmentDate)
    {
        LocalDate today = LocalDate.now();
        if (enrollmentDate == null || enrollmentDate.isAfter(LocalDate.of(today.getYear(), today.getMonthValue(), today.getDayOfMonth())))
        {
            throw new InternalError("The enrollment date must be after the current date...");
        }
        this.enrollmentDate = enrollmentDate;
        this.dropDate = null;
    }
    
    /**
     * Setter
     * @param dropDate Data de saida do estudante
     */
    public void setDropDate(LocalDate dropDate) throws InternalError
    {
        if (dropDate.isBefore(enrollmentDate))
        {
            throw new InternalError("The dropDate must be after enrollment date...");
        }
        this.dropDate = dropDate;
        this.enrollmentDate = null;
    }
    
    /**
     * Getter
     * @return Data de entrada do estudante 
     */
    public LocalDate getEnrollmentDate()
    {
        return this.enrollmentDate;
    }
    
    /**
     * Getter
     * @return Data de saida do estudante 
     */
    public LocalDate getDropDate()
    {
        return this.dropDate;
    }
    
    
    @Override
    protected String appendToString() 
    {
        StringBuilder output = new StringBuilder();
        output.append("  //Student" + AppConfig.NEW_LINE);
        output.append("  enrollmentDate = ");
        output.append(((dropDate == null) ? null : dropDate.format(AppConfig.DATE_FORMAT)) + AppConfig.NEW_LINE);
        return output.toString();
    }
}