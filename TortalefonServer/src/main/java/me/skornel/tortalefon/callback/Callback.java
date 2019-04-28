package me.skornel.tortalefon.callback;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Callback {

    private String name;
    private String id;
    private CallbackType type;
    private String address;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    public Callback() {
        this.creationDate = LocalDateTime.now();
    }

    public Callback(CallbackType type, String address) {
        this.type = type;
        this.address = address;
        this.creationDate = LocalDateTime.now();
    }

    public Callback(CallbackType type, String address, LocalDateTime creationDate) {
        this.type = type;
        this.address = address;
        this.creationDate = creationDate;
    }

    @JsonIgnore
    public String getTypeDescription(){
        return type.getDescription();
    }

}
