package com.backend.demoHabr.Chapter;

import com.backend.demoHabr.Subchapt.Subchapt;
import com.backend.demoHabr.Subchapt.SubchapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/chapters")
@CrossOrigin
public class ChapterController {

    private final ChapterRepository chapterRepository;
//    private final SubchapterRepository subchapterRepository;
//
    @Autowired
    public ChapterController(ChapterRepository chapterRepository){
        this.chapterRepository = chapterRepository;
    }

    @GetMapping("/all")
    public List<Chapter> getAllChapters(){
        return chapterRepository.findAll();
    }

    @GetMapping("/titles")
    public List<String> getTitlesChapters(){
        List<Chapter> chapters = chapterRepository.findAll();
        List<String> titles = new ArrayList<>();
        for (Chapter chapter : chapters)
            titles.add(chapter.getName());
        return titles;
    }

    @GetMapping("/{chapterName}")
    public List<Subchapt> getSubchapters(@PathVariable("chapterName") String chapterName){
        Optional<Chapter> chapters = chapterRepository.findChapterByName(chapterName);
        if (chapters.isEmpty())
            throw new IllegalStateException("chapter with name" + chapterName + "not found");
        return chapters.get().getSubchaptList();
    }

    @PostMapping(path = "/crch")
    public Chapter createChapter(@RequestBody Chapter chapter){
        Optional<Chapter> optionalChapter = chapterRepository.findChapterByName(chapter.getName());
        if(optionalChapter.isPresent())
            throw new IllegalStateException("name is taken");
        chapterRepository.save(chapter);
        return chapter;
    }
//
//    @PostMapping(name = "/crsubch")
//    public Subchapt createSubchapter(@RequestBody Subchapt subchapt){
//        Chapter chapter = chapterRepository.findById(subchapt.getChapterId()).orElseThrow(() ->
//                new IllegalStateException((" --!incorrect chapter id!-- ")));
//        subchapterRepository.save(subchapt);
//        // todo: add to chapter list of subch
//        return subchapt;
//    }


}
