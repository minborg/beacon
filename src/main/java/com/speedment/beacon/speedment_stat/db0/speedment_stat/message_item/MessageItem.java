package com.speedment.beacon.speedment_stat.db0.speedment_stat.message_item;

import com.speedment.beacon.speedment_stat.db0.speedment_stat.message.Message;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.message.MessageField;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.message.MessageManager;
import com.speedment.core.core.entity.Entity;
import com.speedment.core.exception.SpeedmentException;
import com.speedment.core.manager.metaresult.MetaResult;
import com.speedment.util.json.Json;
import java.lang.Long;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the Table 'speedment_stat.db0.speedment_stat.message_item'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment.
 * Any changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment 
 */
@Generated("Speedment")
@Entity(managerType = MessageItemManager.class,
        builderType = MessageItemBuilder.class,
        primaryKeyType = Long.class)
public interface MessageItem {
    
    Long getId();
    
    Long getMessage();
    
    String getKey();
    
    String getValue();
    
    default Message findMessage() {
        return MessageManager.get().stream()
            .filter(MessageField.ID.equal(getMessage()))
            .findAny().orElseThrow(() -> new SpeedmentException(
                "Foreign key constraint error. Message is set to " + getMessage()
                ));
            
    }
    
    static MessageItemBuilder builder() {
        return MessageItemManager.get().builder();
    }
    
    default MessageItemBuilder toBuilder() {
        return MessageItemManager.get().toBuilder(this);
    }
    
    default String toJson() {
        return MessageItemManager.get().toJson(this);
    }
    
    default String toJson(Json<MessageItem> json) {
        return json.build(this);
    }
    
    static Stream<MessageItem> stream() {
        return MessageItemManager.get().stream();
    }
    
    default Optional<MessageItem> persist() {
        return MessageItemManager.get().persist(this);
    }
    
    default Optional<MessageItem> update() {
        return MessageItemManager.get().update(this);
    }
    
    default Optional<MessageItem> remove() {
        return MessageItemManager.get().remove(this);
    }
    
    default Optional<MessageItem> persist(Consumer<MetaResult<MessageItem>> listener) {
        return MessageItemManager.get().persist(this, listener);
    }
    
    default Optional<MessageItem> update(Consumer<MetaResult<MessageItem>> listener) {
        return MessageItemManager.get().update(this, listener);
    }
    
    default Optional<MessageItem> remove(Consumer<MetaResult<MessageItem>> listener) {
        return MessageItemManager.get().remove(this, listener);
    }
}