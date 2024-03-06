package com.ums.entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Office")
@NoArgsConstructor
@AllArgsConstructor
public class Office extends Base {


    @NotEmpty(message = "Office name is required")
    @Column(unique = true)
    private String officeName;

    @NotEmpty(message = "Region is required")
    private String region;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<OfficeBranch> branches = new ArrayList<>();
}
