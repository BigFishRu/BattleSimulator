package com.example.battlesimulator

import android.graphics.Canvas
import kotlin.random.Random

abstract class AbstractWarrior(
    private val maxHealth: Int, override  var dodgeChance: Int,private  var hitAccuracy: Int,
    private var weapon: AbstractWeapon, private val armor: Boolean) : Warrior {
    private var currentHealth: Int = maxHealth
    override var isKilled: Boolean = false

    fun getCurrentHealth1(): Int = currentHealth

    override fun attack(warrior: Warrior) {
        var shootAmmo = weapon.shoot()
        var damage: Int = 0
        var armorСoefficient: Float
        shootAmmo.forEach {
            if ((0..101).random() > warrior.dodgeChance && (0..101).random() > this.hitAccuracy){
                armorСoefficient = if (armor) {
                    when (it) {
                        Ammo.Normal -> 1.5F
                        Ammo.Expensive -> 2F
                        Ammo.Penetrating -> 0.75F
                    }
                } else {
                    when (it) {
                        Ammo.Normal -> 1F
                        Ammo.Expensive -> 0.5F
                        Ammo.Penetrating -> 1.75F
                    }
                }
                damage += (it.currentDamageCalculator() / armorСoefficient).toInt()
            }
        }
        warrior.takeDamage(damage)
    }

    override fun takeDamage(damage: Int) {
        currentHealth -= damage
        if (currentHealth <= 0){
            this.isKilled = true
        }
    }



}