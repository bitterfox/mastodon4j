/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.nil.mastodon.bitter_fox.mastodon4j.api;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import static jdk.nashorn.internal.objects.NativeArray.map;
import lombok.extern.slf4j.Slf4j;
import nu.nil.mastodon.bitter_fox.mastodon4j.entity.Account;

/**
 *
 * @author bitter_fox
 */
@Slf4j
public class Client {
        
    private ClientConfiguration config;
    private WebTarget endpoint;

    public Client(ClientConfiguration config) {
        this.config = config;
        endpoint = ClientBuilder.newClient()
                .target(config.endpoint);
    }


    public Account account(String id) {
        return getWithAuth("api/v1/accounts/{id}", 
                                Collections.singletonMap("id", id),
                                Account.class);
    }

    public Account currentAccount() {
        return getWithAuth("/api/v1/accounts/verify_credentials", Account.class);
    }

    public void updateCurrentAccount() {
        // TODO
    }

    public List<Account> followers(String id) { // TODO Paging
        return getWithAuth("/api/v1/accounts/"+id+"/followers",
                new GenericType<List<Account>>(){});
    }

    public List<Account> following(String id) { // TODO Paging
        return getWithAuth("/api/v1/accounts/" + id + "/following",
                new GenericType<List<Account>>(){});
    }
    
    public Account doFollow(String id) {
        return postWithAuth("/api/v1/accounts/" + id + "/follow" ,Account.class);
    }
    public Account doUnfollow(String id) {
        return postWithAuth("/api/v1/accounts/" + id + "/unfollow", Account.class);
    }

    private <T> T getWithAuth(String path, Class<T> clazz) {
        return getWithAuth(path, Collections.emptyMap(), clazz);
    }
    private <T> T getWithAuth(String path, Map<String, Object> pathParams, Class<T> clazz) {
        log.info("GET {}", path);
        return endpoint.path(path)
                .resolveTemplates(pathParams)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + config.accessToken)
                .get(clazz);
    }

    private <T> T getWithAuth(String path, GenericType<T> clazz) {
        log.info("GET {}", path);
        return endpoint.path(path)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + config.accessToken)
                .get(clazz);
    }

    private <T> T postWithAuth(String path, Class<T> clazz) {
        log.info("POST {}", path);
        return endpoint.path(path)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + config.accessToken)
                .post(Entity.text(""), clazz);
    }


}
