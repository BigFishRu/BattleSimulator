package com.example.battlesimulator

sealed class FireType()

class SingleType(private val numberOfAmmo: Int = 1): FireType()
class FocusType(private val numberOfAmmo: Int = 3): FireType()
fun turnType(boolean: Boolean): FireType = when (boolean){
    true -> FocusType()
    else -> SingleType()
}