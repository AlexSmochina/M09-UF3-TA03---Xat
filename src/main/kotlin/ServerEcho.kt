import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class ServerEcho:Thread, Runnable {
    private var socket: Socket
    private var numConnexio: Int

    constructor(socket: Socket, numConnexio: Int) {
        this.socket = socket
        this.numConnexio = numConnexio
    }

    override fun run(){

        val input = BufferedReader(InputStreamReader(socket.getInputStream()))

        val out = PrintWriter(socket.getOutputStream(), true)
        out.println("Hola! Ets el client $numConnexio")

        var inputLine = input.readLine()
        while (inputLine != null) {
            var missatge = "Client: $numConnexio - M'ha dit: $inputLine"
            out.println(missatge)
            println(missatge)
            inputLine = input.readLine()
        }
        out.close()
        input.close()
        socket.close()
    }
}