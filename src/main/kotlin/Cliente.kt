
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

fun main(){

    val sck = Socket("localhost", 9267)

    val out = PrintWriter(sck.getOutputStream(), true)

    val input = BufferedReader(InputStreamReader(sck.getInputStream()))

    val stdIn = BufferedReader(InputStreamReader(System.`in`))

    var inputLine : String

    inputLine = input.readLine()
    println(inputLine)

    inputLine = stdIn.readLine()
    while (inputLine != null){
        out.println(inputLine)
        val missatge = input.readLine()
        println(missatge)
        inputLine = stdIn.readLine()
    }
}