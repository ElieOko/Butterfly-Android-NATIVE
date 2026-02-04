package elieoko.me.butterfly.core.store.relational.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TVersionBibles")
class VersionBibleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "nom")
    var nom : String,
    @ColumnInfo(name = "langue_id")
    val langueId : Int,
    @ColumnInfo(name = "abreviation")
    val abreviation : String,
    @ColumnInfo(name = "copyright")
    val copyright : String

)