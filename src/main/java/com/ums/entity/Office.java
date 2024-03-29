package com.ums.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Office")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Office extends Base{
    @NotEmpty
    @Column(unique = true)
    private String officeName;
    @NotEmpty
    private String region;
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OfficeBranch> officeBranches;
}