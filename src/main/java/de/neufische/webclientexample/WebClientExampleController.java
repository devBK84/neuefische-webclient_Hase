package de.neufische.webclientexample;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class WebClientExampleController {
    @GetMapping("/github-repos")
    public Repo[] getGithubRepos () {
        Repo[] repos = WebClient
            .builder()
            .baseUrl("https://api.github.com")
            .build()
            .method(HttpMethod.GET)
            .uri("/users/neuefische/repos")
            .exchangeToMono(
                clientResponse -> clientResponse.bodyToMono(Repo[].class)
            ).block();

        return repos;
    }

    @PostMapping("/users")
    public User createUser (@RequestBody NewUser newUser) {
        User user = WebClient
            .builder()
            .baseUrl("https://reqres.in")
            .build()
            .method(HttpMethod.DELETE)
            .uri("/api/users")
            .bodyValue(newUser)
            .exchangeToMono(
                    clientResponse -> clientResponse.bodyToMono(User.class)
            ).block();

        return user;
    }
}
