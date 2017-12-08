
package Module;

import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 * 
 * Interface-klasse for Moduler. Alle metoder som er definert av inteface
 * må også implementeres i source-koden.
 */
@Local
public interface ModuleManagerLocal {
    ModuleOppgave getModuleOppgave(int id);
    boolean saveModuleOppgave(ModuleOppgave m);
    boolean updateModuleOppgave(ModuleOppgave m);
}