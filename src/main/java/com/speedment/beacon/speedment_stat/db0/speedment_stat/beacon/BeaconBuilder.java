package com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon;

import com.speedment.core.core.Buildable;
import java.sql.Timestamp;
import javax.annotation.Generated;

/**
 * A builder representing an entity (for example, a row) in the Table 'speedment_stat.db0.speedment_stat.beacon'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment.
 * Any changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment 
 */
@Generated("Speedment")
public interface BeaconBuilder extends Beacon, Buildable<Beacon> {
    
    BeaconBuilder setId(Long id);
    
    BeaconBuilder setCreated(Timestamp created);
    
    BeaconBuilder setIpAddress(String ipAddress);
}