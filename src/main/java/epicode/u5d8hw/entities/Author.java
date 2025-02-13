package epicode.u5d8hw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Il nome è obbligatorio")
    private String name;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String surname;

    @Email(message = "Email non valida")
    @NotBlank(message = "L'email è obbligatoria")
    private String email;

    @NotBlank(message = "La data di nascita è obbligatoria")
    private String dateOfBirth;

    @Size(min = 6, message = "L'avatar deve essere una stringa valida (URL o nome file valido)")
    private String avatar;

    // Relazioni
    // @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    // @JsonIgnore // Per evitare loop di serializzazione
    // private List<BlogPost> blogpostList;
}
