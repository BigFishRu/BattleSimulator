package com.example.battlesimulator

import android.graphics.Canvas
import android.graphics.RectF

class Team() {
    private var money: Int = 100_000;
    private var warriorList: MutableList<AbstractWarrior> = mutableListOf()
    fun confrontation(enemy: Team){
        warriorList.forEach { itExternal ->
            when(itExternal) {
                is Sniper -> if ((0..100).random() <= 60 && enemy.warriorList.firstOrNull() { it is HeavyInfantryman } != null)
                    itExternal.attack(enemy.warriorList.first() { it is HeavyInfantryman })
                else itExternal.attack(enemy.warriorList[(0 until enemy.warriorList.size).random()])

                is HeavyInfantryman -> if ((0..100).random() <= 30 && enemy.warriorList.firstOrNull() { it is Sniper } != null)
                    itExternal.attack(enemy.warriorList.first() { it is Sniper })
                else itExternal.attack(enemy.warriorList[(0 until enemy.warriorList.size).random()])

                is Infantryman -> if ((0..100).random() <= 20 && enemy.warriorList.firstOrNull() { it is Sniper } != null)
                    itExternal.attack(enemy.warriorList.first() { it is Sniper })
                else itExternal.attack(enemy.warriorList[(0 until enemy.warriorList.size).random()])
            }
        }
    }
    fun getMoney(): Int{
        return money
    }
    fun mixList(){
        warriorList.removeAll{ it.isKilled }
        warriorList.shuffle()
    }
    fun buySniper(){
        if(money >=  2_000) {
            money -= 2_000
            warriorList.add(Sniper())
        }
    }
    fun buyHeavyInfantryman(){
        if(money >= 4_000) {
            money -= 4_000
            warriorList.add(HeavyInfantryman())
        }
    }
    fun buyInfantryman(){
        if(money >= 1000) {
            money -= 1000
            warriorList.add(Infantryman())
        }
    }
    fun randomBuy(){
        while(money != 0) {
            when ((0..3).random()) {
                0 -> if (money > 2_000) buySniper() else buyInfantryman()
                1 -> buyInfantryman()
                2 -> if (money > 4_000) buyHeavyInfantryman() else buyInfantryman()
            }
        }
    }

    override fun toString(): String {
        var count = 0
        warriorList.forEach { count += it.getCurrentHealth1() }
        return count.toString()
    }

}