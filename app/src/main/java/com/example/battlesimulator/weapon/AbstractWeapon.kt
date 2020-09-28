package com.example.battlesimulator

abstract class AbstractWeapon(private val maxNumberOfAmmo: Int,private  var fireType: FireType) {
    private var magazine: MutableList<Ammo> = mutableListOf()
    private var singleType: Boolean = fireType is SingleType
    fun checkEmpty(): Boolean{
        return magazine.isEmpty()
    }
    private fun reload() {
        while (magazine.size != maxNumberOfAmmo) {
            magazine.add(0, createAmmo())
        }
    }
    fun shoot(): MutableList<Ammo>{
        var queueAmmo: MutableList<Ammo> = mutableListOf()
        when(fireType){
            is SingleType -> {
                if (magazine.size > 0) {
                    queueAmmo.add(magazine[0])
                    magazine.removeAt(0)
                }
                else reload()
            }
            is FocusType -> {

                for (i in 0..3) {
                    if (i >= magazine.size){
                        reload()
                        break
                    }
                    queueAmmo.add(magazine[0])
                    magazine.removeAt(0)
                }

            }
        }
        return queueAmmo
    }
    fun chengeFireType(){
        fireType = when (singleType){
            true -> turnType(false)
            else -> turnType(true)
        }
    }

    abstract fun createAmmo(): Ammo
    
}