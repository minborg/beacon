package com.speedment.beacon.speedment_stat.db0.speedment_stat.message;

import com.speedment.core.field.reference.ComparableReferenceField;
import com.speedment.core.field.reference.string.StringReferenceField;
import java.sql.Timestamp;
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
public final class MessageField {
    
    public final static ComparableReferenceField<Message, Long> ID = new ComparableReferenceField<>(() -> findColumn(Message.class, "id"), Message::getId);
    public final static ComparableReferenceField<Message, Timestamp> CREATED = new ComparableReferenceField<>(() -> findColumn(Message.class, "created"), Message::getCreated);
    public final static StringReferenceField<Message> IPADDRESS = new StringReferenceField<>(() -> findColumn(Message.class, "ipAddress"), Message::getIpAddress);
    public final static StringReferenceField<Message> IPADDRESSNAME = new StringReferenceField<>(() -> findColumn(Message.class, "ipAddressName"), o -> o.getIpAddressName().orElse(null));
    public final static ComparableReferenceField<Message, Integer> REMOTEPORT = new ComparableReferenceField<>(() -> findColumn(Message.class, "remotePort"), Message::getRemotePort);
    public final static StringReferenceField<Message> GUI = new StringReferenceField<>(() -> findColumn(Message.class, "gui"), o -> o.getGui().orElse(null));
    public final static StringReferenceField<Message> COREFULLVERSION = new StringReferenceField<>(() -> findColumn(Message.class, "coreFullVersion"), o -> o.getCoreFullVersion().orElse(null));
    public final static StringReferenceField<Message> SESSIONID = new StringReferenceField<>(() -> findColumn(Message.class, "sessionId"), o -> o.getSessionId().orElse(null));
    public final static StringReferenceField<Message> VERSION = new StringReferenceField<>(() -> findColumn(Message.class, "version"), o -> o.getVersion().orElse(null));
    public final static StringReferenceField<Message> TYPE = new StringReferenceField<>(() -> findColumn(Message.class, "type"), o -> o.getType().orElse(null));
    public final static StringReferenceField<Message> REGID = new StringReferenceField<>(() -> findColumn(Message.class, "regId"), o -> o.getRegId().orElse(null));
    
    private MessageField() {
        
    }
}