package com.rick.posadka.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posadka_shaft")
data class PosadkaShaft(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "size")
    val size: Int,
    @ColumnInfo(name = "prev_size")
    val prevSize: Int,
    @ColumnInfo(name = "class")
    val name: String,
    @ColumnInfo(name = "highdeviation")
    val highDeviation: Double,
    @ColumnInfo(name = "lowdeviation")
    val lowDeviation: Double

)

/*
TableInfo{name='posadka_hole', columns={id=Column{name='id', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='undefined'}, size=Column{name='size', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, prevsize=Column{name='prevsize', type='INTEGER', affinity='3', notNull=false, primaryKeyPosition=0, defaultValue='undefined'}, class=Column{name='class', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, highdeviation=Column{name='highdeviation', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'},lowdeviation=Column{name='lowdeviation', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}}, foreignKeys=[], indices=[]}
Found:
TableInfo{name='posadka_hole', columns={id=Column{name='id', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='undefined'}, size=Column{name='size', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, prevsize=Column{name='prevsize', type='INTEGER', affinity='3', notNull=false, primaryKeyPosition=0, defaultValue='undefined'}, class=Column{name='class', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, highdeviation=Column{name='highdeviation', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, lowdeviaton=Column{name='lowdeviaton', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}}, foreignKeys=[], indices=[]}

    */
