package tg.project.db.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "chat_id", unique = true, nullable = false, length = 50)
    @JsonIgnore
    private String chatId;

    @Column(name = "command", unique = false, nullable = true, length = 255)
    private String command;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_serials",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "serial_id")
    )
    @JsonIgnore
    @ToString.Exclude
    private Set<Serial> serials = new HashSet<>();

    public User(String chatId) {
        this.chatId = chatId;
        this.command = null;
    }

}