package com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon;

import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property.BeaconProperty;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property.BeaconPropertyField;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property.BeaconPropertyManager;
import com.speedment.core.core.entity.Entity;
import com.speedment.core.manager.metaresult.MetaResult;
import com.speedment.util.json.Json;
import java.lang.Long;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the Table 'speedment_stat.db0.speedment_stat.beacon'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment.
 * Any changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment 
 */
@Generated("Speedment")
@Entity(managerType = BeaconManager.class,
        builderType = BeaconBuilder.class,
        primaryKeyType = Long.class)
public interface Beacon {
    
    Long getId();
    
    Timestamp getCreated();
    
    String getIpAddress();
    
    default Stream<BeaconProperty> beaconPropertiesByBeacon() {
        return BeaconPropertyManager.get()
                .stream().filter(BeaconPropertyField.BEACON.equal(this.getId()));
    }
    
    default Stream<BeaconProperty> beaconProperties() {
        return beaconPropertiesByBeacon();
    }
    
    static BeaconBuilder builder() {
        return BeaconManager.get().builder();
    }
    
    default BeaconBuilder toBuilder() {
        return BeaconManager.get().toBuilder(this);
    }
    
    default String toJson() {
        return BeaconManager.get().toJson(this);
    }
    
    default String toJson(Json<Beacon> json) {
        return json.build(this);
    }
    
    static Stream<Beacon> stream() {
        return BeaconManager.get().stream();
    }
    
    default Optional<Beacon> persist() {
        return BeaconManager.get().persist(this);
    }
    
    default Optional<Beacon> update() {
        return BeaconManager.get().update(this);
    }
    
    default Optional<Beacon> remove() {
        return BeaconManager.get().remove(this);
    }
    
    default Optional<Beacon> persist(Consumer<MetaResult<Beacon>> listener) {
        return BeaconManager.get().persist(this, listener);
    }
    
    default Optional<Beacon> update(Consumer<MetaResult<Beacon>> listener) {
        return BeaconManager.get().update(this, listener);
    }
    
    default Optional<Beacon> remove(Consumer<MetaResult<Beacon>> listener) {
        return BeaconManager.get().remove(this, listener);
    }
}