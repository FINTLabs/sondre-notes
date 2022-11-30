package no.fintlabs.note;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    @Builder.Default
    private Date date = new Date();
    private String note;
}

