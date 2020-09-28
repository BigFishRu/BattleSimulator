package com.example.battlesimulator

interface Warrior {
    var isKilled: Boolean
    var dodgeChance: Int
    fun attack(warrior: Warrior)
    fun takeDamage(damage: Int)
}