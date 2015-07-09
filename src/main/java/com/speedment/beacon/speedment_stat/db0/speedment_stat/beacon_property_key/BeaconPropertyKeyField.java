package com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property_key;

import com.speedment.core.field.reference.ComparableReferenceField;
import com.speedment.core.field.reference.string.StringReferenceField;
import javax.annotation.Generated;
import static com.speedment.core.field.FieldUtil.findColumn;

/**
 * Interface representing the fields of an entity.
 * 
 * <p>
 * This Class or Interface has been automatically generated by Speedment.
 * Any changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment 
 */
@Generated("Speedment")
public final class BeaconPropertyKeyField {
    
    public final static ComparableReferenceField<BeaconPropertyKey, Integer> ID = new ComparableReferenceField<>(() -> findColumn(BeaconPropertyKey.class, "id"), BeaconPropertyKey::getId);
    public final static StringReferenceField<BeaconPropertyKey> KEY = new StringReferenceField<>(() -> findColumn(BeaconPropertyKey.class, "key"), BeaconPropertyKey::getKey);
    
    private BeaconPropertyKeyField() {
        
    }
}