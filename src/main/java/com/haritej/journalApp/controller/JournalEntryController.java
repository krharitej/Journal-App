package com.haritej.journalApp.controller;

import com.haritej.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private HashMap<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(), entry);
        return true;
    }

    @GetMapping("/id/{id}")
    public JournalEntry getById(@PathVariable Long id){
        return journalEntries.get(id);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteById(@PathVariable Long id){
        journalEntries.remove(id);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateById(@PathVariable Long id, @RequestBody JournalEntry entry){
        return journalEntries.put(id, entry);
    }
}
