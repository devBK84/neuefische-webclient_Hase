package de.neufische.webclientexample;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class WebClientExampleController {
    @GetMapping("/github-repos")
    public Repo[] getGithubRepos() {
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
    public User createUser(@RequestBody NewUser newUser) {
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

    @GetMapping("githubfritz")
    public Repo[] GetFritzUser() {
        Repo[] repos = WebClient
                .builder()
                .baseUrl("https://api.github.com")
                .build()
                .method(HttpMethod.GET)
                .uri("/user/neuefische/repos")
                .exchangeToMono(
                        clientResponse -> clientResponse.bodyToMono(Repo[].class)
                ).block();

        return repos;
    }

    @GetMapping("aufgabe")
    public void aufgabe() {
        Animal animal = WebClient
                .builder()
                .baseUrl("https://eoq2vuf7lltn3qi.m.pipedream.net")
                .build()
                .method(HttpMethod.GET)
                .uri("/8")
                .exchangeToMono(
                        clientResponse -> clientResponse.bodyToMono(Animal.class)
                ).block();

    }

    @GetMapping("2")
    public Success GetRepo() {
        Animal animal = WebClient
                .builder()
                .baseUrl("https://eoq2vuf7lltn3qi.m.pipedream.net")
                .build()
                .method(HttpMethod.GET)
                .uri("/2")
                .exchangeToMono(
                        clientResponse -> clientResponse.bodyToMono(Animal.class)
                ).block();
        Hase bringSichUm = new Hase(8, animal.toString());
        Success success = WebClient
                .builder()
                .baseUrl("https://eolhzflzeqdbtg3.m.pipedream.net")
                .build()
                .method(HttpMethod.POST)
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(bringSichUm)
                .exchangeToMono(
                        clientResponse -> clientResponse.bodyToMono(Success.class)
                ).block();

        return success;
    }

}
