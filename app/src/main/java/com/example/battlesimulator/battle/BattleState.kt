package com.example.battlesimulator

sealed class BattleState {
    abstract var text: String
}
class Progress(private val redTeam: Team, private val blueTeam: Team) : BattleState() {
    override var text: String = "Жизни бойцов красной команды = ${redTeam.toString()}\nЖизни бойцов голубой команды${blueTeam.toString()}\n"
}
class WinRed() : BattleState(){
    override var text: String = "Красная команда победила\n"
}
class WinBlue() : BattleState(){
    override var text: String = "Синяя команда победила\n"
}
class Draw() : BattleState(){
    override var text: String = "Ничья\n"
}
fun battleState(redTeam: Team, blueTeam: Team) = when {
    redTeam.toString().toInt() == 0 -> WinBlue()
    blueTeam.toString().toInt() == 0 -> WinRed()
    redTeam.toString().toInt() == 0 && blueTeam.toString().toInt() == 0 -> Draw()
    else -> Progress(redTeam, blueTeam)
}




