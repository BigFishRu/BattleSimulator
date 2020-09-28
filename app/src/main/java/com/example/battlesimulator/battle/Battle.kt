package com.example.battlesimulator

class Battle(var redTeam: Team, var blueTeam: Team) {
    var battleIsOver: Boolean = false

    fun getBattleState(): BattleState{
        return battleState(redTeam, blueTeam)
    }
    fun nextBattle(){
        redTeam.confrontation(blueTeam)
        blueTeam.confrontation(redTeam)
        redTeam.mixList()
        blueTeam.mixList()
        if (getBattleState() is WinRed || getBattleState() is WinBlue){
            battleIsOver = true
        }
    }
}