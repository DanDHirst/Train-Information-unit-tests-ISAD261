/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traininfomation;

/**
 *
 * @author dan
 */
public class TrainInfo {
    private String name;
    private String arrives;
    private String departs;

    public TrainInfo(String name, String arrives, String departs) {
        this.name = name;
        this.arrives = arrives;
        this.departs = departs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArrives() {
        return arrives;
    }

    public void setArrives(String arrives) {
        this.arrives = arrives;
    }

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }
    
    
}
