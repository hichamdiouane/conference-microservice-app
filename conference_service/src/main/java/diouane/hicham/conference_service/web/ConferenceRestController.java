package diouane.hicham.conference_service.web;

import diouane.hicham.conference_service.entities.Conference;
import diouane.hicham.conference_service.feign.KeynoteRestClient;
import diouane.hicham.conference_service.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ConferenceRestController {
    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private KeynoteRestClient keynoteRestClient;

    @GetMapping(path = "/conferences/{id}")
    public Conference getConference(@PathVariable Long id){
        Conference conference = conferenceRepository.findById(id).get();
        conference.setKeynote(keynoteRestClient.getKeynoteById(conference.getKeynoteId()));

        return conference;
    }
}
