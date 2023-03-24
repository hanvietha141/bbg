package com.bbg.api;

import com.bbg.dto.TalentDTO;
import com.bbg.service.impl.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class TalentAPI {
    @Autowired
    private TalentService talentService;
    @GetMapping(value="/talent")
    public ArrayList<TalentDTO> getTalent() {
        return talentService.getTalent();
    }

}
