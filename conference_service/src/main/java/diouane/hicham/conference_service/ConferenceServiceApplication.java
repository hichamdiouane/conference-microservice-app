package diouane.hicham.conference_service;

import diouane.hicham.conference_service.entities.Conference;
import diouane.hicham.conference_service.entities.Review;
import diouane.hicham.conference_service.entities.TypeConference;
import diouane.hicham.conference_service.feign.KeynoteRestClient;
import diouane.hicham.conference_service.model.Keynote;
import diouane.hicham.conference_service.repository.ConferenceRepository;
import diouane.hicham.conference_service.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ConferenceRepository billRepository,
                                        ReviewRepository productItemRepository,
                                        KeynoteRestClient customerRestClient){

        return args -> {
            Collection<Keynote> keynotes = customerRestClient.getAllKeynotes().getContent();

            keynotes.forEach(keynote -> {
                Conference conference = Conference.builder()
                        .keynoteId(keynote.getId())
                        .titre("Conference on ")
                        .type(TypeConference.valueOf("COMERCIAL"))
                        .date(new Date())
                        .duree(60)
                        .nb_inscrits(100)
                        .score(4.5)
                        .build();
                billRepository.save(conference);
                Review review = Review.builder()
                        .conference(conference)
                        .text("Great conference!")
                        .note(5)
                        .date(new Date())
                        .build();
                productItemRepository.save(review);
            });
        };
    }
}
