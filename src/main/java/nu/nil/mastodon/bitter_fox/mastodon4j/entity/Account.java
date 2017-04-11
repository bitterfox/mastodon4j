/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.nil.mastodon.bitter_fox.mastodon4j.entity;

import java.net.URL;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author bitter_fox
 */
@Data
@XmlRootElement
public class Account {

    private String id;
    private String username;
    private String acct;
    @XmlElement(name = "display_name")
    private String displayName;
    private String note;
    private URL url;
    private URL avatar;
    private URL header;
    private boolean locked;
    @XmlElement(name = "created_at")
    private String createdAt;
    @XmlElement(name = "followers_count")
    private int followersCount;
    @XmlElement(name = "following_count")
    private int followingCount;
    @XmlElement(name = "statuses_count")
    private int statusesCount;

}
