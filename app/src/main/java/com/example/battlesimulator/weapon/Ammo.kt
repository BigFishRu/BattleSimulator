package com.example.battlesimulator

import kotlin.random.Random

enum class Ammo(private val damage: Int, private val criticalChance: Int, private val criticalX : Double) {
    Normal(20, (0..101).random(), 1.25),
    Expensive(20, (0..101).random(), 2.toDouble()),
    Penetrating(25, (0..101).random(), 1.5);
    private fun checkCriticalDamage(): Int {
        return if ((0..101).random() < criticalChance){
            (damage * criticalX).toInt()
        } else damage
    }
    fun currentDamageCalculator(): Int {
        return checkCriticalDamage()
    }
}