package br.com.learn.controller

import br.com.learn.converters.NumberConverter.convertToDouble
import br.com.learn.converters.NumberConverter.isNumeric
import br.com.learn.exceptions.UnssuportedMathOperationException
import br.com.learn.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    private val math: SimpleMath = SimpleMath();

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable("numberOne") numberOne: String?, @PathVariable("numberTwo") numberTwo: String?): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnssuportedMathOperationException("Please set a numeric value!");
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable("numberOne") numberOne: String?, @PathVariable("numberTwo") numberTwo: String?): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnssuportedMathOperationException("Please set a numeric value!");
        return math.sub(convertToDouble(numberOne), convertToDouble(numberTwo));
    }


    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable("numberOne") numberOne: String?, @PathVariable("numberTwo") numberTwo: String?): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnssuportedMathOperationException("Please set a numeric value!");
        return math.mult(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable("numberOne") numberOne: String?, @PathVariable("numberTwo") numberTwo: String?): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnssuportedMathOperationException("Please set a numeric value!");

        if (convertToDouble(numberTwo) == 0.0) throw UnssuportedMathOperationException("Isn't possible division by zero.")

        return math.div(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = ["/square/{numberOne}"])
    fun square(@PathVariable("numberOne") numberOne: String?): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberOne))
            throw UnssuportedMathOperationException("Please set a numeric value!");

        val numberDouble = convertToDouble(numberOne)

        return math.square(numberDouble);
    }


}