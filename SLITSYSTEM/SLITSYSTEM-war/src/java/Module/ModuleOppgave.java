
package Module;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;




@Entity
public class ModuleOppgave implements Serializable{
    @Id
    @Column
    private int ModuleOppgaveID;
    @Column
    private String task;
    @Column
    private String Criterias;
    @Column 
    private String deadline;

    public ModuleOppgave(int ModuleOppgaveID, String task, String Criterias, String deadline) {
        this.ModuleOppgaveID = ModuleOppgaveID;
        this.task = task;
        this.Criterias = Criterias;
        this.deadline = deadline;
    }
    public ModuleOppgave()
    {}

    public int getModuleOppgaveID() {
        return ModuleOppgaveID;
    }

    public void setModuleOppgaveID(int ModuleOppgaveID) {
        this.ModuleOppgaveID = ModuleOppgaveID;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCriterias() {
        return Criterias;
    }

    public void setCriterias(String Criterias) {
        this.Criterias = Criterias;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
}

    