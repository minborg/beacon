package com.speedment.beacon.speedment_stat.db0.speedment_stat.frontend;

import com.speedment.core.core.entity.Entity;
import com.speedment.core.manager.metaresult.MetaResult;
import com.speedment.util.json.Json;
import java.lang.Long;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the Table 'speedment_stat.db0.speedment_stat.frontend'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment.
 * Any changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment 
 */
@Generated("Speedment")
@Entity(managerType = FrontendManager.class,
        builderType = FrontendBuilder.class,
        primaryKeyType = Long.class)
public interface Frontend {
    
    Long getId();
    
    Optional<String> getRegId();
    
    Optional<String> getFirstName();
    
    Optional<String> getLastName();
    
    Optional<String> getEmail();
    
    Optional<String> getOrganization();
    
    Optional<String> getCountry();
    
    Optional<String> getPhone();
    
    Optional<String> getVersion();
    
    String getCoreFullVersion();
    
    Timestamp getCreated();
    
    String getIpAddress();
    
    String getIpAddressName();
    
    Integer getRemotePort();
    
    Optional<String> getComment();
    
    static FrontendBuilder builder() {
        return FrontendManager.get().builder();
    }
    
    default FrontendBuilder toBuilder() {
        return FrontendManager.get().toBuilder(this);
    }
    
    default String toJson() {
        return FrontendManager.get().toJson(this);
    }
    
    default String toJson(Json<Frontend> json) {
        return json.build(this);
    }
    
    static Stream<Frontend> stream() {
        return FrontendManager.get().stream();
    }
    
    default Optional<Frontend> persist() {
        return FrontendManager.get().persist(this);
    }
    
    default Optional<Frontend> update() {
        return FrontendManager.get().update(this);
    }
    
    default Optional<Frontend> remove() {
        return FrontendManager.get().remove(this);
    }
    
    default Optional<Frontend> persist(Consumer<MetaResult<Frontend>> listener) {
        return FrontendManager.get().persist(this, listener);
    }
    
    default Optional<Frontend> update(Consumer<MetaResult<Frontend>> listener) {
        return FrontendManager.get().update(this, listener);
    }
    
    default Optional<Frontend> remove(Consumer<MetaResult<Frontend>> listener) {
        return FrontendManager.get().remove(this, listener);
    }
}