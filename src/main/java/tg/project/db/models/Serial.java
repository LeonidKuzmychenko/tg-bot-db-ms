package tg.project.db.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "serials")
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_id", unique = true, nullable = false, length = 100)
    private String apiId;

    @ManyToMany(mappedBy = "serials", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Serial(String apiId) {
        this.apiId = apiId;
    }

}