package com.example.battlesimulator

object Weapon {
    val M14 = object : AbstractWeapon(20, SingleType()){
        override fun createAmmo(): Ammo = Ammo.Penetrating
    }
    val FAMAS = object : AbstractWeapon(25, FocusType()){
        override fun createAmmo(): Ammo = Ammo.Expensive
    }
    val Mosina = object : AbstractWeapon(5, SingleType()){
        override fun createAmmo(): Ammo = Ammo.Normal
    }
}