/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.nil.mastodon.bitter_fox.mastodon4j.api;

/**
 *
 * @author bitter_fox
 */
public class ClientConfiguration {
    
    final String endpoint;
    final String accessToken;

    public ClientConfiguration(String endpoint, String accessToken) {
        this.endpoint = endpoint;
        this.accessToken = accessToken;
    }
    
}
