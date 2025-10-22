package diouane.hicham.keynoteservice;

import diouane.hicham.keynoteservice.entities.Keynote;
import diouane.hicham.keynoteservice.reporisitory.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository ){
        return args -> {
            keynoteRepository.save(Keynote.builder()
                    .prenom("Hicham").nom("Diouane").email("hicham@gmail.com").fonction("Developer")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .prenom("Ahmed").nom("Ahmed").email("ahmed@gmail.com").fonction("Manager")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .prenom("Abdo").nom("Abdo").email("abdo@gmail.com").fonction("Architect")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .prenom("test").nom("test").email("test@gmail.com").fonction("Tester")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .prenom("test2").nom("test2").email("test2@gmail.com").fonction("DevOps")
                    .build());
            keynoteRepository.findAll().forEach(c->{
                System.out.println("======================");
                System.out.println(c.getId());
                System.out.println(c.getNom());
                System.out.println(c.getEmail());
                System.out.println("=======================");
            });
        };
    }
}
