/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.nil.mastodon.bitter_fox.mastodon4j.entity;

import java.net.URL;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author bitter_fox
 */
@XmlRootElement
@Data
public class Tag {
    
    private String name;
    private URL url;
    
}
