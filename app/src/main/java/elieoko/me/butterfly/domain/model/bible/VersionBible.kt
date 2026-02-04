package elieoko.me.butterfly.domain.model.bible

import elieoko.me.butterfly.core.store.relational.room.entity.VersionBibleEntity

data class VersionBible(
    val id : Int,
    val nom : String,
    val langueId : Int,
    val abreviation : String,
    val copyrigth : String
)

fun VersionBible.toEntity() = VersionBibleEntity(
    id = this.id,
    nom = this.nom,
    langueId = this.langueId,
    abreviation = this.abreviation,
    copyright = this.copyrigth,
)