/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.nil.mastodon.bitter_fox.mastodon4j.entity;

import javax.xml.bind.annotation.XmlElement;
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
public class Toot {
    
    @XmlElement(name = "status")
    private String toot;
    
    
}
