package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(
        indexes = {
                @Index(name = "utilisateur_notif_ctrl_id_idx", columnList = "utilisateur_id")
        }
)
public class NotificationControle extends AbstractEntity {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_utilisateur_notification_ctrl"))
    private Utilisateur utilisateur;
}
