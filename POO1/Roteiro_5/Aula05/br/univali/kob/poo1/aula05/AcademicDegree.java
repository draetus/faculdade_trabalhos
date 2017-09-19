package br.univali.kob.poo1.aula05;

/**
 * Enum representando os graus de formação do professor
 * atribuindo os modificadores de salario junto
 * @author Mauricio
 */
public enum AcademicDegree
    {
        BACHELOR("Bachelor", "0.00"),
        MASTER("Master", "0.15"),
        DOCTORATE("Doctorate (PhD)", "0.30");
        
        private String description;
        
        private String bonus;
        
        public String getDescription()
        {
            return description;
        }
        
        public String getBonus()
        {
            return bonus;
        }
        
        private AcademicDegree(String description, String bonus)
        {
            this.description = description;
            this.bonus = bonus;
        }
    }
