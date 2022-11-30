package no.fintlabs.note;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/notes")
public class NotesController {

    private final NotesRepository repository;

    public NotesController(NotesRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        log.debug("Adding note with id {}", note.getId());

        repository.addOrUpdate(note);

        return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return ResponseEntity.ok(repository.getNotes());
    }
}
