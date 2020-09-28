package com.example.battlesimulator

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Sniper(private val maxHealth: Int = 40, override  var dodgeChance: Int = 50, private  var hitAccuracy: Int = 80,
             private var weapon: AbstractWeapon = Weapon.M14, private val armor: Boolean = false) : AbstractWarrior(
            maxHealth, dodgeChance,hitAccuracy, weapon, armor = armor) {


}