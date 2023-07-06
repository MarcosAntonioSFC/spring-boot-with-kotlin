package br.com.learn.math

import kotlin.math.sqrt

class SimpleMath {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo;
    fun sub(numberOne: Double, numberTwo: Double) = numberOne - numberTwo;
    fun mult(numberOne: Double, numberTwo: Double) = numberOne * numberTwo;
    fun div(numberOne: Double, numberTwo: Double) = numberOne / numberTwo;
    fun mean(numberOne: Double, numberTwo: Double) = div((numberOne + numberTwo), 2.0);
    fun square(number: Double) = sqrt(number);


}