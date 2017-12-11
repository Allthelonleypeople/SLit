
package Module;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;




@Entity
public class ModuleOppgave implements Serializable{
    @Id //Markerer at dette feltet er PK i tabellen.
    @Column
    private int ModuleOppgaveID;
    @Column
    private String task;
    @Column
    private String Criterias;
    @Column 
    private String deadline;

    /**
     * Constructor for Modul
     * @param ModuleOppgaveID
     * @param task
     * @param Criterias
     * @param deadline
     */
    public ModuleOppgave(int ModuleOppgaveID, String task, String Criterias, String deadline) {
        this.ModuleOppgaveID = ModuleOppgaveID;
        this.task = task;
        this.Criterias = Criterias;
        this.deadline = deadline;
    }
    
    /**
     * Det er meningen at denne constructoren skal være tom.
     */
    public ModuleOppgave()
    {
    }

    /**
     * Herfra og ned er det bare Setters og getters
     * for de forskjellige feltene
     * @return
     */
    public int getModuleOppgaveID() {
        return ModuleOppgaveID;
    }
    
    /**
     *
     * @param ModuleOppgaveID
     */
    public void setModuleOppgaveID(int ModuleOppgaveID) {
        this.ModuleOppgaveID = ModuleOppgaveID;
    }

    /**
     *
     * @return
     */
    public String getTask() {
        return task;
    }

    /**
     *
     * @param task
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     *
     * @return
     */
    public String getCriterias() {
        return Criterias;
    }

    /**
     *
     * @param Criterias
     */
    public void setCriterias(String Criterias) {
        this.Criterias = Criterias;
    }

    /**
     *
     * @return
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     *
     * @param deadline
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
}

    