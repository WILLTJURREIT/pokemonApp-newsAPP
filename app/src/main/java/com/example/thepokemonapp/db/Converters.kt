package com.example.thepokemonapp.db

import androidx.room.TypeConverter


@TypeConverter
fun fromString(value: String): MyType {
    return MyType(value)
}

@TypeConverter
fun toString(myType: MyType): String {
    return myType.toString()
}
