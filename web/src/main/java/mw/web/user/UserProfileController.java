package mw.web.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {

    private mw.web.user.UserProfileRepository userProfileRepository;

    public UserProfileController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping
    public List<UserProfileEntry> findAllProfiles() {
        return userProfileRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileEntry> getProfileById(@PathVariable("id") String id) {
        return userProfileRepository.findById(id).map(t -> ResponseEntity.status(HttpStatus.OK).body(t))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody UserProfileEntry profile) {
        UserProfileEntry savedProfile = userProfileRepository.save(profile);
        return ResponseEntity.created(URI.create(String
                .format("/api/profiles/%s", savedProfile.getId()
                        .toString()))).build();
    }

    @PatchMapping("/{id}")
    public void replace(@PathVariable("id") String id, @RequestBody UserProfileEntry profile) {
        profile.setId(id);
        userProfileRepository.save(profile);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        userProfileRepository.deleteById(id);
    }
}
