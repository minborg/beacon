package com.speedment.beacon.speedment_stat.db0.speedment_stat.message_item;

import com.speedment.beacon.speedment_stat.db0.speedment_stat.message.Message;
import com.speedment.core.field.reference.ComparableReferenceField;
import com.speedment.core.field.reference.ComparableReferenceForeignKeyField;
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
public final class MessageItemField {
    
    public final static ComparableReferenceField<MessageItem, Long> ID = new ComparableReferenceField<>(() -> findColumn(MessageItem.class, "id"), MessageItem::getId);
    public final static ComparableReferenceForeignKeyField<MessageItem, Long, Message> MESSAGE = new ComparableReferenceForeignKeyField<>(() -> findColumn(MessageItem.class, "message"), MessageItem::getMessage, MessageItem::findMessage);
    public final static StringReferenceField<MessageItem> KEY = new StringReferenceField<>(() -> findColumn(MessageItem.class, "key"), MessageItem::getKey);
    public final static StringReferenceField<MessageItem> VALUE = new StringReferenceField<>(() -> findColumn(MessageItem.class, "value"), MessageItem::getValue);
    
    private MessageItemField() {
        
    }
}