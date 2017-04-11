/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.nil.mastodon.bitter_fox.mastodon4j.entity;

import java.net.URI;
import java.net.URL;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author bitter_fox
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class Status {

    private String status;
    private String id;
    private URI uri;
    private URL url;
    private Account account;
    private String in_reply_to_id;
    private String in_reply_to_account_id;
    private String reblog;
    private String content;
    private String created_at;
    private int reblogs_count;
    private int favourites_count;
    private boolean reblogged;
    private boolean favourited;
    private String sensitive;
    private String spoiler_text;
    private String visibility; // TODO enum Visibility { PUBLIC, ..., ; }
    private String media_attachments;
    private String mentions;
    private List<Tag> tags;
    private String application;

}
