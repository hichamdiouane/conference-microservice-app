package diouane.hicham.conference_service.feign;

import diouane.hicham.conference_service.model.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.hateoas.PagedModel;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("/api/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable Long id);

    @GetMapping("/api/keynotes")
    PagedModel<Keynote> getAllKeynotes();
}
