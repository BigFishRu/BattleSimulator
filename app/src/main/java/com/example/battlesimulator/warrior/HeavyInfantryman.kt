package com.example.battlesimulator

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class HeavyInfantryman(
    private val maxHealth: Int = 35, override  var dodgeChance: Int = 30, private  var hitAccuracy: Int = 50,
    private var weapon: AbstractWeapon = Weapon.FAMAS, private val armor: Boolean = true) : AbstractWarrior(
                        maxHealth, dodgeChance,hitAccuracy, weapon, armor = armor) {
    private var currentHealth: Int = maxHealth

}