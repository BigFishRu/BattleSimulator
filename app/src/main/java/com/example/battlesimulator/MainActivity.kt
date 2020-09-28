package com.example.battlesimulator



import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {
    var blueTeam: Team = Team()
    var redTeam: Team = Team()
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }


    fun onClickBuyInfantryman(view: View){
        blueTeam.buyInfantryman()
        moneyView.text = "Ваши деньги = ${blueTeam.getMoney()}$"
    }
    fun onClickBuyHeavyInfantryman(view: View){
        blueTeam.buyHeavyInfantryman()
        moneyView.text = "Ваши деньги = ${blueTeam.getMoney()}$"
    }

    fun onClickBuySniper(view: View){
        blueTeam.buySniper()
        moneyView.text = "Ваши деньги = ${blueTeam.getMoney()}$"
    }

    fun onClickStart(view: View){
        redTeam.randomBuy()
        val battle = Battle(redTeam, blueTeam)
        buyHeavyInfantryman.visibility = View.GONE
        buyInfantryman.visibility = View.GONE
        buySniper.visibility = View.GONE
        start.visibility = View.GONE
        moneyView.visibility = View.GONE
        restart.visibility = View.VISIBLE
        val bS = findViewById<TextView>(R.id.tv_battle_state_text)
        progressBlueTeam.max = blueTeam.toString().toInt()
        progressRedTeam.max = redTeam.toString().toInt()
        Thread(Runnable {
            while (!battle.battleIsOver) {
                handler.post{
                    progressBlueTeam.progress = blueTeam.toString().toInt()
                    progressRedTeam.progress = redTeam.toString().toInt()
                    bS.append(battle.getBattleState().text + "\n")
                }
                Thread.sleep(700)
                battle.nextBattle()

            }
            handler.post{
                bS.append(battle.getBattleState().text + "\n")
                progressBlueTeam.progress = blueTeam.toString().toInt()
                progressRedTeam.progress = redTeam.toString().toInt()
            }

        }).start()


    }
    @SuppressLint("SetTextI18n")
    fun onClickRestart(view: View){
        blueTeam = Team()
        redTeam = Team()
        buyHeavyInfantryman.visibility = View.VISIBLE
        buyInfantryman.visibility = View.VISIBLE
        buySniper.visibility = View.VISIBLE
        start.visibility = View.VISIBLE
        moneyView.visibility = View.VISIBLE
        restart.visibility = View.GONE
        moneyView.text = "Ваши деньги = ${blueTeam.getMoney()}$"
        progressBlueTeam.progress = 0
        progressRedTeam.progress = 0
        findViewById<TextView>(R.id.tv_battle_state_text).text = ""
    }

}