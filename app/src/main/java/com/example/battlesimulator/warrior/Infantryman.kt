package com.example.battlesimulator

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Infantryman (private val maxHealth: Int = 50, override  var dodgeChance: Int = 40, private  var hitAccuracy: Int = 65,
    private var weapon: AbstractWeapon = Weapon.Mosina, private val armor: Boolean = false) : AbstractWarrior(
                        maxHealth, dodgeChance,hitAccuracy, weapon, armor = armor) {
    private var currentHealth: Int = maxHealth

}