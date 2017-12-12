
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;
import Module.ModuleOppgave; 
import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author RasmusRS
 */
@Entity
public class Plan implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private int planID; 
    @Column
    private String courseName; 
    @Column
    private String numbOfModules; 
    @Column 
    private String planningInfo; 
    
    public Plan(String courseName, String numbOfModules, String planningInfo){
        this.courseName = courseName; 
        this.numbOfModules = numbOfModules; 
        this.planningInfo = planningInfo; 
    }

    /**
     *
     * @return planID
     */
    public int getPlanID() {
        return planID;
    }

    /**
     * set planID
     * @param planID
     */
    public void setPlanID(int planID) {
        this.planID = planID;
    }

    /**
     *
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * set courseName
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     *
     * @return number of modules
     */
    public String getNumbOfModules() {
        return numbOfModules;
    }

    /**
     * set number of modules
     * @param numbOfModules
     */
    public void setNumbOfModules(String numbOfModules) {
        this.numbOfModules = numbOfModules;
    }

    /**
     * 
     * @return info about planned progression
     */
    public String getPlanningInfo() {
        return planningInfo;
    }

    /**
     * set info about planned progression in the course. 
     * @param planningInfo
     */
    public void setPlanningInfo(String planningInfo) {
        this.planningInfo = planningInfo;
    }
    
    protected Plan(){}
}
